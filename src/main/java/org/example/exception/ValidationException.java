package org.example.exception;

import org.example.model.Error;

import java.util.List;

public class ValidationException extends Exception {
    private List<Error> messages;
    private Integer errorCode;




    public ValidationException(List<Error> errorList, int errorCode) {
        this.messages = errorList;
        this.errorCode = errorCode;
    }

    public List<Error> getMessages() {
        return messages;
    }

    public Integer getErrorCode() {
        return errorCode;
    }
}
