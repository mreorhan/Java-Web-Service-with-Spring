package com.mreorhan.ws.ui.model.response;

public enum ErrorMessages {
    MISSING_REQUIRED_FIELD("1"),
    RECORD_ALREADY_EXISTS("2"),
    INTERNAL_SERVER_ERROR("3"),
    NO_RECORD_FOUND("4"),
    AUTHENTICATION_FAILED("5"),
    COULD_NOT_UPDATE_RECORD("6"),
    COULD_NOT_DELETE_RECORD("7"),
    EMAIL_ADDRESS_NOT_VERIFIED("8");

    private String errorMessage;

    ErrorMessages(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
