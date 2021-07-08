package br.com.grupo3.socialmeli.dto;

public class FollowingExceptionDto {

    private final String message;

    public FollowingExceptionDto(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
