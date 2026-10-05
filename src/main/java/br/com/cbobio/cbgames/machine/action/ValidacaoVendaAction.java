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
public class ValidacaoVendaAction implements Action<StatusVenda, EventoVenda> {

    @Override
    public void execute(StateContext<StatusVenda, EventoVenda> context) {

        log.info("Executando validação da venda.");

        // TODO
        // Validar cliente
        // Validar itens
        // Calcular valor total
        // Validar estoque

    }

}