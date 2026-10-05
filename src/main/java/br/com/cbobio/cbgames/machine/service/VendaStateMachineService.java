package br.com.cbobio.cbgames.machine.service;

import br.com.cbobio.cbgames.machine.constant.StateMachineConstants;
import br.com.cbobio.cbgames.machine.enums.estados.StatusVenda;
import br.com.cbobio.cbgames.machine.enums.eventos.EventoVenda;
import br.com.cbobio.cbgames.persistence.entity.TbVenda;
import br.com.cbobio.cbgames.persistence.repository.VendaRepository;
import br.com.cbobio.cbgames.service.exceptions.VendaNaoEncontradaException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.statemachine.support.DefaultStateMachineContext;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class VendaStateMachineService {

    private final StateMachineFactory<StatusVenda, EventoVenda> stateMachineFactory;

    private final VendaRepository vendaRepository;

    /**
     * Dispara um evento na State Machine da venda.
     */
    public TbVenda enviarEvento(Long vendaId, EventoVenda evento) {

        TbVenda venda = buscarVenda(vendaId);

        StateMachine<StatusVenda, EventoVenda> stateMachine =
                criarStateMachine(venda);

        enviarEvento(stateMachine, evento);

        atualizarStatusVenda(venda, stateMachine);

        return salvarVenda(venda);
    }

    /**
     * Busca a venda no banco.
     */
    private TbVenda buscarVenda(Long vendaId) {

        return vendaRepository.findById(vendaId)
                .orElseThrow(() ->
                        new VendaNaoEncontradaException(
                                "Venda não encontrada: " + vendaId));
    }

    /**
     * Cria a State Machine no estado atual da venda.
     */
    private StateMachine<StatusVenda, EventoVenda> criarStateMachine(TbVenda venda) {

        StateMachine<StatusVenda, EventoVenda> stateMachine =
                stateMachineFactory.getStateMachine(venda.getId().toString());

        stateMachine.stopReactively().block();

        stateMachine.getStateMachineAccessor()
                .doWithAllRegions(access ->
                        access.resetStateMachineReactively(
                                new DefaultStateMachineContext<>(
                                        venda.getStatusVenda(),
                                        null,
                                        null,
                                        null
                                )
                        ).block()
                );

        stateMachine.getExtendedState()
                .getVariables()
                .put(StateMachineConstants.VENDA, venda);

        stateMachine.startReactively().block();

        return stateMachine;
    }

    /**
     * Envia um evento para a máquina.
     */
    private void enviarEvento(StateMachine<StatusVenda, EventoVenda> stateMachine,
                              EventoVenda evento) {

        Message<EventoVenda> message = MessageBuilder
                .withPayload(evento)
                .build();

        boolean sucesso = stateMachine.sendEvent(message);

        if (!sucesso) {
            throw new IllegalStateException(
                    "Não foi possível executar o evento: " + evento);
        }
    }

    /**
     * Atualiza o status da venda.
     */
    private void atualizarStatusVenda(TbVenda venda,
                                      StateMachine<StatusVenda, EventoVenda> stateMachine) {

        venda.setStatusVenda(stateMachine.getState().getId());

    }

    /**
     * Persiste a venda.
     */
    private TbVenda salvarVenda(TbVenda venda) {

        return vendaRepository.save(venda);

    }

}