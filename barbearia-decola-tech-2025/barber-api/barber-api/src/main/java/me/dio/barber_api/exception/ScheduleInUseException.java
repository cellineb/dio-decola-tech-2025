package me.dio.barber_api.exception;

public class ScheduleInUseException extends RuntimeException {
    public ScheduleInUseException(String message) {
        super(message);
    }
}
