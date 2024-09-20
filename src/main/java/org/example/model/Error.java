package org.example.model;

public class Error {
    private String errorMsg;
    private String errorKey;

    public Error(String errorMsg, String errorKey) {
        this.errorMsg = errorMsg;
        this.errorKey = errorKey;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public String getErrorKey() {
        return errorKey;
    }

    @Override
    public String toString() {
        return "Error{" +
                "errorMsg='" + errorMsg + '\'' +
                ", errorKey='" + errorKey + '\'' +
                '}';
    }
}
