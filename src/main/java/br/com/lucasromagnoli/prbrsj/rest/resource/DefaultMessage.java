package br.com.lucasromagnoli.prbrsj.rest.resource;

import org.springframework.http.HttpStatus;

import java.util.Map;

public class DefaultMessage {

    private String message;
    private HttpStatus httpStatus;
    private DefaultMessageCategory category;
    private Map details;

    public DefaultMessage(String message, HttpStatus httpStatus, DefaultMessageCategory category, Map details) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.category = category;
        this.details = details;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public DefaultMessageCategory getCategory() {
        return category;
    }

    public Map getDetails() {
        return details;
    }
}
