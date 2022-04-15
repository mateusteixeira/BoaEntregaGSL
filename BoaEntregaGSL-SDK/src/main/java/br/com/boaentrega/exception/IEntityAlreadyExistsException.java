package br.com.boaentrega.exception;

public class IEntityAlreadyExistsException extends RuntimeException {

    public IEntityAlreadyExistsException(String message) {
        super(message);
    }
}
