package com.example.coronatracking.application.model.response;

public class ResponsePasswordReset {

    private String resetToken;

    public ResponsePasswordReset() { }

    public ResponsePasswordReset(String resetToken) {
        this.resetToken = resetToken;
    }

    public String getResetToken() {
        return resetToken;
    }

    public void setResetToken(String resetToken) {
        this.resetToken = resetToken;
    }
}
