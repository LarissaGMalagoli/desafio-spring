package br.com.grupo3.socialmeli.dto;

import br.com.grupo3.socialmeli.model.Post;
import br.com.grupo3.socialmeli.model.Seller;
import br.com.grupo3.socialmeli.model.User;

import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.List;

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
