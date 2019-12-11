package br.com.lucasromagnoli.prbrsj.rest.errors;

import br.com.lucasromagnoli.prbrsj.rest.resource.DefaultMessage;
import br.com.lucasromagnoli.prbrsj.rest.resource.DefaultMessageCategory;
import br.com.lucasromagnoli.prbrsj.rest.support.DefaultMessageSupport;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ErrorHandlerRestController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<DefaultMessage> handleExample(IllegalArgumentException ex) {

        return DefaultMessageSupport.createResponseEntity(DefaultMessageCategory.WARNING, ex.getMessage(),HttpStatus.BAD_REQUEST);
    }
}
