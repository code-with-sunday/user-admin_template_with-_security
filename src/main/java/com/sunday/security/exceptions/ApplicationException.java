package com.sunday.security.exceptions;

public class ApplicationException extends RuntimeException{
    private final String customMessage;

    public ApplicationException(String customMessage) {
        super(customMessage);
        this.customMessage = customMessage;
    }
}
