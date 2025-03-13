package me.dio.barber_api.exception;

public class EmailInUseException extends RuntimeException {
    public EmailInUseException(String message) {
        super(message);
    }
}
