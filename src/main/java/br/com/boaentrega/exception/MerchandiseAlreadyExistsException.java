package br.com.boaentrega.exception;

public class MerchandiseAlreadyExistsException extends RuntimeException {

    public MerchandiseAlreadyExistsException(String message) {
        super(message);
    }
}
