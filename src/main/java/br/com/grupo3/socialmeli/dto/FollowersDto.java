package br.com.grupo3.socialmeli.dto;

import br.com.grupo3.socialmeli.model.Seller;

public class FollowersDto {
    private Long userId;
    private String username;
    private int followersCount;

    public FollowersDto(Seller seller) {
        this.userId = seller.getUserId();
        this.username = seller.getUserName();
        this.followersCount = seller.getFollowersCount();
    }

    public Long getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public int getFollowersCount() {
        return followersCount;
    }

}
