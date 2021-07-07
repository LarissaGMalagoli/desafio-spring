package br.com.grupo3.socialmeli.config.exceptions.handler;

import br.com.grupo3.socialmeli.config.exceptions.PersonNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PersonHandler {


    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(PersonNotFoundException.class)
    public String notFoundHandler(PersonNotFoundException personNotFoundException){
        return personNotFoundException.getMessage();
    }
}
