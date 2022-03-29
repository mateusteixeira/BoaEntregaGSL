package br.com.boaentrega.exception;

public class WareHouseAlreadyExistsException extends RuntimeException {

    public WareHouseAlreadyExistsException(String message) {
        super(message);
    }
}
