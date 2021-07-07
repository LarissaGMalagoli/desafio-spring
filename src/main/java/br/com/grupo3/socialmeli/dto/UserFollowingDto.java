package br.com.grupo3.socialmeli.dto;

import java.util.List;

public class UserFollowingDto {

    private Long userId;
    private String userName;
    private List<SellerFollowedDto> sellerDtos;

    public UserFollowingDto(Long userId, String userName, List<SellerFollowedDto> sellerDtos) {
        this.userId = userId;
        this.userName = userName;
        this.sellerDtos = sellerDtos;
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

    public List<SellerFollowedDto> getSellerDtos() {
        return sellerDtos;
    }

    public void setSellerDtos(List<SellerFollowedDto> sellerDtos) {
        this.sellerDtos = sellerDtos;
    }
}
