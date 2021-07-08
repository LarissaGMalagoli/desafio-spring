package br.com.grupo3.socialmeli.config.exceptions.handler;

import br.com.grupo3.socialmeli.config.exceptions.FollowingException;
import br.com.grupo3.socialmeli.config.exceptions.PersonNotFoundException;
import br.com.grupo3.socialmeli.dto.FollowingExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class FollowHandler {

    @ExceptionHandler(FollowingException.class)
    public ResponseEntity<FollowingExceptionDto> notFoundHandler(FollowingException followingException){
        return ResponseEntity.badRequest().body(new FollowingExceptionDto(followingException.getMessage()));
    }
}
