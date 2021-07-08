package br.com.grupo3.socialmeli.dto;


public class PersonNotFoundDto {

    private final Long targetId;
    private final String message;

    public PersonNotFoundDto(String message, Long targetId) {
        this.targetId = targetId;
        this.message = message;
    }

    public Long getTargetId() {
        return targetId;
    }

    public String getMessage() {
        return message;
    }
}
