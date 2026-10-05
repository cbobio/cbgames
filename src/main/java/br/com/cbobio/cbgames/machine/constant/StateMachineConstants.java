package br.com.cbobio.cbgames.machine.constant;

public final class StateMachineConstants {

    private StateMachineConstants() {
        throw new UnsupportedOperationException("Classe utilitária.");
    }

    /**
     * Chave utilizada para armazenar a venda no ExtendedState.
     */
    public static final String VENDA = "VENDA";

    /**
     * Chave para armazenar o usuário responsável.
     */
    public static final String USUARIO = "USUARIO";

    /**
     * Chave para armazenar o cliente.
     */
    public static final String CLIENTE = "CLIENTE";

}