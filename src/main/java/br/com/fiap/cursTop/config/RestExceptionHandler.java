package br.com.fiap.cursTop.config;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.fiap.cursTop.models.RestValidationError;

@RestControllerAdvice
public class RestExceptionHandler {

    Logger log = LoggerFactory.getLogger(getClass());
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<RestValidationError>> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e){
        log.error("erro de validacao");
        List<RestValidationError> erros = new ArrayList<>();
        e.getFieldErrors().forEach(v -> erros.add(new RestValidationError(v.getField(), v.getDefaultMessage())));

        return ResponseEntity.badRequest().body(erros);
    }

}
