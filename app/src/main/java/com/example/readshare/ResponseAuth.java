package com.example.readshare;

public class ResponseAuth {
    private Boolean Success;

    private String Message;

    private long UserId;

    public Boolean getSuccess() {
        return Success;
    }

    public void setSuccess(Boolean success) {
        Success = success;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public void setUserId(long userId) {
        UserId = userId;
    }

    public long getUserId() {
        return UserId;
    }
}
