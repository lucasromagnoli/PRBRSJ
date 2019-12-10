package br.com.lucasromagnoli.prbrsj.rest.support;

import br.com.lucasromagnoli.prbrsj.rest.resource.DefaultMessage;
import br.com.lucasromagnoli.prbrsj.rest.resource.DefaultMessageCategory;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

public class DefaultMessageSupport {

    private String message;
    private HttpStatus httpStatus;
    private DefaultMessageCategory category;
    private Map<String, String> details;

    public DefaultMessageSupport(String message) {
        this.message = message;
        this.httpStatus = HttpStatus.OK;
        this.category = DefaultMessageCategory.INFORMATION;
        this.details = new HashMap();
    }

    public static DefaultMessageSupport message(String message) {
        return new DefaultMessageSupport(message);
    }

    public static DefaultMessageSupport message() {
        return new DefaultMessageSupport(null);
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
