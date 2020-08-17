package com.example.coronatracking.application.model.response;

public class ResponseJwtAuth {

    private String accessToken;
    private String tokenType = "Bearer";
    private ResponseUser user;

    public ResponseJwtAuth() { }

    public ResponseJwtAuth(String accessToken, ResponseUser user) {
        this.accessToken = accessToken;
        this.user = user;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public ResponseUser getUser() {
        return user;
    }

    public void setUser(ResponseUser user) {
        this.user = user;
    }
}