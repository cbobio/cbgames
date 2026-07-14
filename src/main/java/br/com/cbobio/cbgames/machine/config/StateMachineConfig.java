package br.com.cbobio.cbgames.machine.config;

import br.com.cbobio.cbgames.machine.action.*;
import br.com.cbobio.cbgames.machine.enums.estados.StatusVenda;
import br.com.cbobio.cbgames.machine.enums.eventos.EventoVenda;
import br.com.cbobio.cbgames.machine.guard.CancelamentoGuard;
import br.com.cbobio.cbgames.machine.guard.EstoqueGuard;
import br.com.cbobio.cbgames.machine.guard.PagamentoGuard;
import br.com.cbobio.cbgames.machine.guard.VendaValidaGuard;
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


    private final ValidacaoVendaAction validacaoVendaAction;
    private final PagamentoAction pagamentoAction;
    private final EntregaAction entregaAction;
    private final ConclusaoAction conclusaoAction;
    private final CancelamentoAction cancelamentoAction;

    private final VendaValidaGuard vendaValidaGuard;
    private final PagamentoGuard pagamentoGuard;
    private final EstoqueGuard estoqueGuard;
    private final CancelamentoGuard cancelamentoGuard;

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
                .guard(vendaValidaGuard)
                .action(validacaoVendaAction)

                .and()

                .withExternal()
                .source(StatusVenda.VALIDADO)
                .target(StatusVenda.PAGO)
                .event(EventoVenda.PAGAR)
                .guard(pagamentoGuard)
                .action(pagamentoAction)

                .and()

                .withExternal()
                .source(StatusVenda.PAGO)
                .target(StatusVenda.ENTREGUE)
                .event(EventoVenda.ENVIAR)
                .guard(estoqueGuard)
                .action(entregaAction)

                .and()

                .withExternal()
                .source(StatusVenda.ENTREGUE)
                .target(StatusVenda.COMPLETADO)
                .event(EventoVenda.COMPLETAR)
                .action(conclusaoAction)


                .and()

                .withExternal()
                .source(StatusVenda.VALIDADO)
                .target(StatusVenda.CANCELADO)
                .event(EventoVenda.CANCELAR)
                .guard(cancelamentoGuard)
                .action(cancelamentoAction)

                .and()

                .withExternal()
                .source(StatusVenda.PAGO)
                .target(StatusVenda.CANCELADO)
                .event(EventoVenda.CANCELAR)
                .guard(cancelamentoGuard)
                .action(cancelamentoAction)

                .and()

                .withExternal()
                .source(StatusVenda.NOVO)
                .target(StatusVenda.CANCELADO)
                .event(EventoVenda.CANCELAR)
                .guard(cancelamentoGuard)
                .action(cancelamentoAction)

                .and()

                .withExternal()
                .source(StatusVenda.ENTREGUE)
                .target(StatusVenda.CANCELADO)
                .event(EventoVenda.CANCELAR)
                .guard(cancelamentoGuard)
                .action(cancelamentoAction);
    }

}
