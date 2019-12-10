package br.com.lucasromagnoli.prbrsj.rest.support;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ResponseEntitySupport<T> {

    private T body;
    private HttpStatus httpStatus;

    public ResponseEntitySupport<T> body (T body){
        this.body = body;
        return this;
    }

    public ResponseEntitySupport<T> status (HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
        return this;
    }

    public ResponseEntity<?> buildResponse() {
        return buildFromAttributesOrFill();
    }

    private ResponseEntity<?> buildFromAttributesOrFill() {
        return new ResponseEntity<T>(this.body, this.httpStatus != null ? this.httpStatus : HttpStatus.OK);
    }
}
