package com.example.coronatracking.application.model.request;

public class RequestId {

    private Long id;

    public RequestId() { }

    public RequestId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "RequestId{" +
                "id=" + id +
                '}';
    }
}
