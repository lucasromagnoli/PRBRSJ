package br.com.lucasromagnoli.prbrsj.rest.support;

import br.com.lucasromagnoli.prbrsj.rest.resource.DefaultMessage;
import br.com.lucasromagnoli.prbrsj.rest.resource.DefaultMessageCategory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class DefaultMessageSupport {

    private String message;
    private HttpStatus httpStatus;
    private DefaultMessageCategory category;
    private Map details;

    private DefaultMessageSupport() {
        this.httpStatus = HttpStatus.OK;
        this.category = DefaultMessageCategory.INFORMATION;
    }

    public static DefaultMessageSupport builder(){
        return new DefaultMessageSupport();
    }

    public static ResponseEntity<DefaultMessage> createResponseEntity(
            DefaultMessageCategory defaultMessageCategory, String message, HttpStatus httpStatus) {

        DefaultMessage defaultMessage = new DefaultMessage(message, defaultMessageCategory, httpStatus);
        return new ResponseEntity<>(defaultMessage, httpStatus);
    }

    public DefaultMessageSupport message(String message) {
        this.message = message;
        return this;
    }

    public DefaultMessageSupport httpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
        return this;
    }

    public DefaultMessageSupport category(DefaultMessageCategory category) {
        this.category = category;
        return this;
    }

    public DefaultMessageSupport details(String key, String value) {
        if (details == null) {
            this.details = new HashMap<String, String>();
        }

        this.details.put(key, value);
        return this;
    }

    // TODO: Fazer poder passar um map de String e acrescentar aos details do Message
    public DefaultMessageSupport details(Map<String, String> details) {
        return null;
    }

    public DefaultMessage build() {
        return new DefaultMessage(this.message, this.httpStatus, this.category, this.details);
    }

}
