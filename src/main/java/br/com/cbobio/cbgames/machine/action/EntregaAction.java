package br.com.cbobio.cbgames.machine.action;

import br.com.cbobio.cbgames.machine.enums.estados.StatusVenda;
import br.com.cbobio.cbgames.machine.enums.eventos.EventoVenda;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class EntregaAction implements Action<StatusVenda, EventoVenda> {

    @Override
    public void execute(StateContext<StatusVenda, EventoVenda> context) {

        log.info("Executando entrega da venda.");

        // TODO
        // Baixar estoque
        // Gerar movimentação de estoque
        // Registrar log

    }

}