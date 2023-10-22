package com.hikolu.crudrestapi.exception;

public class DriversErrorResponse {

    private boolean success;
    private int status;
    private String message;

    public DriversErrorResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public DriversErrorResponse(boolean success, int status, String message) {
        this.success = success;
        this.status = status;
        this.message = message;
    }

    public DriversErrorResponse() {
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
