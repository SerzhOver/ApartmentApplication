package com.example.springcrud.exception;

public class WrongDateException extends Exception {

    public WrongDateException() {
        super();
    }

    public WrongDateException(String message) {
        super(message);
    }

    public WrongDateException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongDateException(Throwable cause) {
        super(cause);
    }

    protected WrongDateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
