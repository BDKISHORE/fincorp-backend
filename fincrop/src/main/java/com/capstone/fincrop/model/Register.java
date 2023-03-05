package com.capstone.fincrop.model;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Register<T> {

    private String statusCode;

    private String statusMessage;

    private Optional<T> body;

    public Register() {
    }

    public Register(String statusCode, String statusMessage) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }

    public Register(String statusCode, String statusMessage, Optional<T> body) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
        this.body = body;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public Optional<T> getBody() {
        return body;
    }

    public void setBody(Optional<T> body) {
        this.body = body;
    }
}
