package com.example.coronatracking.application.model.request;

public class RequestPassword {

    private String email;

    public RequestPassword() { }

    public RequestPassword(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
