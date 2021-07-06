package br.com.grupo3.socialmeli.dto;

import br.com.grupo3.socialmeli.model.Seller;
import br.com.grupo3.socialmeli.model.User;

import java.util.List;

public class UserDto {

    private Long userId;
    private String userName;
    private List<Seller> following;

    public UserDto(User user) {
        this.userId = user.getUserId();
        this.userName = user.getUserName();
        this.following = user.getFollowing();
    }

    public Long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public List<Seller> getFollowing() {
        return following;
    }
}
