package br.com.boaentregasupport.exception;

public class CustomerOccurrenceAlreadyExistsException extends RuntimeException {

    public CustomerOccurrenceAlreadyExistsException(String message) {
        super(message);
    }
}
