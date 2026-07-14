package br.com.cbobio.cbgames.machine.guard;

import br.com.cbobio.cbgames.machine.enums.estados.StatusVenda;
import br.com.cbobio.cbgames.machine.enums.eventos.EventoVenda;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.guard.Guard;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CancelamentoGuard implements Guard<StatusVenda, EventoVenda> {

    @Override
    public boolean evaluate(StateContext<StatusVenda, EventoVenda> context) {

        log.info("Validando cancelamento.");

        // TODO
        // Verificar se a venda pode ser cancelada
        // Exemplo:
        // - Não permitir cancelar após concluída

        return true;
    }

}