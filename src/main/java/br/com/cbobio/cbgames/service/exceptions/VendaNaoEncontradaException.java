package br.com.cbobio.cbgames.service.exceptions;

public class VendaNaoEncontradaException extends RuntimeException {
    public VendaNaoEncontradaException(String message) {
        super(message);
    }
}
