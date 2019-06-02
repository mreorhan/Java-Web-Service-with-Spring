package com.mreorhan.ws.exceptions;

public class UserServiceException extends RuntimeException {
    private static final long serialVersionUID = 4L;

    public UserServiceException(String message) {
        super(message);
    }
}
