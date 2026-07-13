package br.com.cbobio.cbgames.machine.action;

import br.com.cbobio.cbgames.machine.enums.estados.StatusVenda;
import br.com.cbobio.cbgames.machine.enums.eventos.EventoVenda;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;

public class ValidacaoPagamentoAction implements Action<StatusVenda, EventoVenda> {
    @Override
    public void execute(StateContext<StatusVenda, EventoVenda> context) {

    }
}
