package com.example.coronatracking.application.model.response;

public class ResponseOperation {

    private Boolean success;
    private String message;
    private String operationName;

    public ResponseOperation(Boolean success, String message, String operationName) {
        this.success = success;
        this.message = message;
        this.operationName = operationName;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }
}

