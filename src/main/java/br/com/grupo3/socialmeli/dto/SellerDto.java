package br.com.grupo3.socialmeli.dto;

import br.com.grupo3.socialmeli.model.Post;
import br.com.grupo3.socialmeli.model.Seller;
import br.com.grupo3.socialmeli.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SellerDto {
    private final int followersCount;
    private final List<String> followersList;

    public SellerDto(Seller seller){
        this.followersCount = seller.getFollowersCount();
        this.followersList =  seller.getFollowers().stream().map( User::getUserName ).collect(Collectors.toList());
    }

    public int getFollowersCount() {
        return followersCount;
    }

    public List<String> getFollowersList() {
        return followersList;
    }
}