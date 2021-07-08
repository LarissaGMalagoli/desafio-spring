package br.com.grupo3.socialmeli.dto;

import br.com.grupo3.socialmeli.model.Seller;
import br.com.grupo3.socialmeli.model.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserDto {

    private Long userId;
    private String userName;
    private List<String> followingNames;
  
    public UserDto(User user) {
        this.userId = user.getUserId();
        this.userName = user.getUserName();
        this.followingNames = user.getFollowing().stream().map(Seller::getUserName).collect(Collectors.toList());
    }

    public Long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public List<String> getFollowingNames() {
        return followingNames;
    }
}