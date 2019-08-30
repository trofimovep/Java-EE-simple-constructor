package com.app.base;

public class MainServiceException extends RuntimeException {

    private ErrorMessage errorMessage;

    public MainServiceException(ErrorMessage errorMessage) {
        this.errorMessage = errorMessage;
    }

    public MainServiceException(String message) {
        super(message);
    }

    public ErrorMessage getErrorMessage() {
        return errorMessage;
    }
}

