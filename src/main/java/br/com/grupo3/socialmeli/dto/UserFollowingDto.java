package br.com.grupo3.socialmeli.dto;

import java.util.List;

public class UserFollowingDto {

    private Long userId;
    private String userName;
    private List<SellerFollowedDto> followed;

    public UserFollowingDto(Long userId, String userName, List<SellerFollowedDto> sellerDtos) {
        this.userId = userId;
        this.userName = userName;
        this.followed = sellerDtos;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<SellerFollowedDto> getFollowed() {
        return followed;
    }

    public void setFollowed(List<SellerFollowedDto> followed) {
        this.followed = followed;
    }
}
