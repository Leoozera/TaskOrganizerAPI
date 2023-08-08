package br.com.fiap.cursTop.config;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.fiap.cursTop.exception.RestValidationException;

@RestControllerAdvice
public class RestExceptionHandler {

    Logger log = LoggerFactory.getLogger(getClass());
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<RestValidationException>> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e){
        log.error("Ocorreu um erro de validação");

        List<RestValidationException> errors = new ArrayList<>();
        e.getFieldErrors().forEach(error -> errors.add(new RestValidationException(error.getField(), error.getDefaultMessage())));

        return ResponseEntity.badRequest().body(errors);
    }

}
