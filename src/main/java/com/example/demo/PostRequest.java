package com.example.demo;

public class PostRequest {
    private String body;

    public PostRequest() {}

    public PostRequest(String body) {
        this.body = body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getBody() {
        return this.body;
    }

}
