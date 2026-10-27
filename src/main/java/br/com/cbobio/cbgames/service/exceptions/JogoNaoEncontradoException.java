package br.com.cbobio.cbgames.service.exceptions;

public class JogoNaoEncontradoException extends RuntimeException {
    public JogoNaoEncontradoException(String message) {
        super(message);
    }
}
