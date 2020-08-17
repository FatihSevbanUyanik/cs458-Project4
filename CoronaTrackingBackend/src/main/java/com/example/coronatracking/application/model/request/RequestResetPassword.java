package com.example.coronatracking.application.model.request;

public class RequestResetPassword {

    private String password;
    private String passwordToken;

    public RequestResetPassword() {}

    public RequestResetPassword(String passwordToken, String password) {
        this.passwordToken = passwordToken;
        this.password = password;
    }

    public String getPasswordToken() {
        return passwordToken;
    }

    public void setPasswordToken(String passwordToken) {
        this.passwordToken = passwordToken;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
