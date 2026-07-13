package br.com.cbobio.cbgames.machine.config;

import br.com.cbobio.cbgames.machine.action.ValidacaoPagamentoAction;
import br.com.cbobio.cbgames.machine.enums.estados.StatusVenda;
import br.com.cbobio.cbgames.machine.enums.eventos.EventoVenda;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachineFactory;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

import java.util.EnumSet;
@RequiredArgsConstructor
@Configuration
@EnableStateMachineFactory
public class StateMachineConfig extends EnumStateMachineConfigurerAdapter<StatusVenda, EventoVenda> {


    private final ValidacaoPagamentoAction validacaoPagamentoAction;

    @Override
    public void configure (StateMachineStateConfigurer<StatusVenda, EventoVenda> states) throws Exception{
        states
                .withStates()
                .initial(StatusVenda.NOVO)
                .states(EnumSet.allOf(StatusVenda.class))
                .end(StatusVenda.COMPLETADO)
                .end(StatusVenda.CANCELADO);
    }

    @Override
    public void configure (StateMachineTransitionConfigurer<StatusVenda, EventoVenda> transitions) throws Exception{
        transitions
                .withExternal()
                .source(StatusVenda.NOVO)
                .target(StatusVenda.VALIDADO)
                .event(EventoVenda.VALIDAR)
                .action(null)

                .and()

                .withExternal()
                .source(StatusVenda.VALIDADO)
                .target(StatusVenda.PAGO)
                .event(EventoVenda.PAGAR)
                .action(validacaoPagamentoAction)

                .and()

                .withExternal()
                .source(StatusVenda.PAGO)
                .target(StatusVenda.ENTREGUE)
                .event(EventoVenda.ENVIAR)
                .action(null)

                .and()

                .withExternal()
                .source(StatusVenda.ENTREGUE)
                .target(StatusVenda.COMPLETADO)
                .event(EventoVenda.COMPLETAR)


                .and()

                .withExternal()
                .source(StatusVenda.VALIDADO)
                .target(StatusVenda.CANCELADO)
                .event(EventoVenda.CANCELAR)

                .and()

                .withExternal()
                .source(StatusVenda.PAGO)
                .target(StatusVenda.CANCELADO)
                .event(EventoVenda.CANCELAR)

                .and()

                .withExternal()
                .source(StatusVenda.NOVO)
                .target(StatusVenda.CANCELADO)
                .event(EventoVenda.CANCELAR)

                .and()

                .withExternal()
                .source(StatusVenda.ENTREGUE)
                .target(StatusVenda.CANCELADO)
                .event(EventoVenda.CANCELAR);
    }

}
