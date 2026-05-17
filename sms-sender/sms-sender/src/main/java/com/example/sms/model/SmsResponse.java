package com.example.sms.model;

public class SmsResponse {

    private String status;
    private String message;

    public SmsResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}