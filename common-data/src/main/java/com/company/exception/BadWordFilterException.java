package com.company.exception;

public class BadWordFilterException extends RuntimeException {

    public BadWordFilterException(String message) {
        super(message);
    }

    public BadWordFilterException(String message, Throwable cause) {
        super(message, cause);
    }
}
