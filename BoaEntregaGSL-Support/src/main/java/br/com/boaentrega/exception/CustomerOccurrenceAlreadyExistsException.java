package br.com.boaentrega.exception;

public class CustomerOccurrenceAlreadyExistsException extends RuntimeException {

    public CustomerOccurrenceAlreadyExistsException(String message) {
        super(message);
    }
}
