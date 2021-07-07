package br.com.grupo3.socialmeli.dto;

import br.com.grupo3.socialmeli.model.Seller;

import java.util.Objects;

public class SellerFollowedDto {
    private Long userId;
    private String userName;

    public SellerFollowedDto(Seller seller) {
        this.userId = seller.getUserId();
        this.userName = seller.getUserName();
    }

    public Long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SellerFollowedDto that = (SellerFollowedDto) o;
        return Objects.equals(userId, that.userId) && Objects.equals(userName, that.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName);
    }
}
