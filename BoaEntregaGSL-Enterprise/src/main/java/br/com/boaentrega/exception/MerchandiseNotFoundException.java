package br.com.boaentrega.exception;

public class MerchandiseNotFoundException extends RuntimeException {

    public MerchandiseNotFoundException(String message) {
        super(message);
    }
}
