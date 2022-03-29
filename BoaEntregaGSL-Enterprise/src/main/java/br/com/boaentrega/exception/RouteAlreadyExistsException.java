package br.com.boaentrega.exception;

public class RouteAlreadyExistsException extends RuntimeException {

    public RouteAlreadyExistsException(String message) {
        super(message);
    }
}
