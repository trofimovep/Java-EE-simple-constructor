package com.plugins.main.services;

import com.app.base.ErrorMessage;

public class ServiceException extends RuntimeException {

    private ErrorMessage errorMessage;

    public ServiceException(ErrorMessage errorMessage) {
        this.errorMessage = errorMessage;
    }

    public ServiceException(String message) {
        super(message);
    }

    public ErrorMessage getErrorMessage() {
        return errorMessage;
    }
}

