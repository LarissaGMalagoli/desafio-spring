package br.com.grupo3.socialmeli.dto;

import br.com.grupo3.socialmeli.model.Seller;

import java.util.List;

public class FollowersListSellerDto {
    private Long userId;
    private String userName;
    private List<FollowersListUserDto> followers;

    public FollowersListSellerDto(Long userId, String userName, List<FollowersListUserDto> followers) {
        this.userId = userId;
        this.userName = userName;
        this.followers = followers;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public List<FollowersListUserDto> getFollowers() {
        return followers;
    }
}
