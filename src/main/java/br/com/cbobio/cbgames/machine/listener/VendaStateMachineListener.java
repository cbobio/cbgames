package br.com.cbobio.cbgames.machine.listener;

import br.com.cbobio.cbgames.machine.enums.estados.StatusVenda;
import br.com.cbobio.cbgames.machine.enums.eventos.EventoVenda;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class VendaStateMachineListener extends StateMachineListenerAdapter<StatusVenda, EventoVenda> {

    @Override
    public void stateChanged(State<StatusVenda, EventoVenda> from,
                             State<StatusVenda, EventoVenda> to) {

        String origem = from == null ? "INICIAL" : from.getId().name();

        log.info("Estado alterado: {} -> {}", origem, to.getId().name());
    }

    @Override
    public void eventNotAccepted(Message<EventoVenda> event) {

        log.warn("Evento não aceito: {}", event.getPayload());
    }

    @Override
    public void stateMachineStarted(org.springframework.statemachine.StateMachine<StatusVenda, EventoVenda> stateMachine) {

        log.info("State Machine iniciada.");
    }

    @Override
    public void stateMachineStopped(org.springframework.statemachine.StateMachine<StatusVenda, EventoVenda> stateMachine) {

        log.info("State Machine finalizada.");
    }

    @Override
    public void transitionStarted(org.springframework.statemachine.transition.Transition<StatusVenda, EventoVenda> transition) {

        if (transition.getSource() != null && transition.getTarget() != null) {
            log.info("Iniciando transição: {} -> {}",
                    transition.getSource().getId(),
                    transition.getTarget().getId());
        }
    }

    @Override
    public void transitionEnded(org.springframework.statemachine.transition.Transition<StatusVenda, EventoVenda> transition) {

        if (transition.getSource() != null && transition.getTarget() != null) {
            log.info("Transição finalizada: {} -> {}",
                    transition.getSource().getId(),
                    transition.getTarget().getId());
        }
    }
}