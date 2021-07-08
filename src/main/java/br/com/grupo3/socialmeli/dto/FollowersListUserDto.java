package br.com.grupo3.socialmeli.dto;

import br.com.grupo3.socialmeli.model.User;

public class FollowersListUserDto {
    private Long userId;
    private String userName;

    public FollowersListUserDto(User user) {
        this.userId = user.getUserId();
        this.userName = user.getUserName();
    }

    public Long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }
}
