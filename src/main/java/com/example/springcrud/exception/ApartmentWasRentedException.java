package com.example.springcrud.exception;

public class ApartmentWasRentedException extends Exception {

    public ApartmentWasRentedException() {
    }

    public ApartmentWasRentedException(String message) {
        super(message);
    }

    public ApartmentWasRentedException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApartmentWasRentedException(Throwable cause) {
        super(cause);
    }
}
