package br.com.boaentrega.exception;

public class CustomerOccurrenceNotFoundException extends RuntimeException {

    public CustomerOccurrenceNotFoundException(String message) {
        super(message);
    }
}
