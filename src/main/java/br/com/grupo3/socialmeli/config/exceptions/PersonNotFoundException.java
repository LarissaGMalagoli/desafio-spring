package br.com.grupo3.socialmeli.config.exceptions;

public class PersonNotFoundException extends RuntimeException {
    public PersonNotFoundException(String user_not_found) {
        super(user_not_found);
    }
}
