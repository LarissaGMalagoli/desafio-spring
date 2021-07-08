package br.com.grupo3.socialmeli.config.exceptions;

public class PersonNotFoundException extends RuntimeException {

    private final Long id;
    public PersonNotFoundException(String message, Long id) {
        super(message);
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
