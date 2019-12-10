package br.com.lucasromagnoli.prbrsj.rest.support;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseEntitySupport<T> {
    private T body;
    private HttpStatus httpStatus;

    public ResponseEntitySupport(T body) {
        this.body = body;
    }

    public static <T> ResponseEntitySupport<T> body (T body){
        return new ResponseEntitySupport(body);
    }

    public static <T> ResponseEntitySupport<T> body (){
        return new ResponseEntitySupport(null);
    }

    public ResponseEntitySupport status(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
        return this;
    }

    public ResponseEntity<?> buildResponse() {
        return buildFromAttributesOrFill();
    }

    public static <T> ResponseEntity<T> buildResponse(T body, HttpStatus httpStatus) {
        return new ResponseEntity<>(body, httpStatus);
    }

    private ResponseEntity<?> buildFromAttributesOrFill() {
        return new ResponseEntity<T>(this.body, this.httpStatus != null ? this.httpStatus : HttpStatus.OK);
    }
}
