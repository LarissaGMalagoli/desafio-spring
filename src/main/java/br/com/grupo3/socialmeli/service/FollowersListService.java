package br.com.grupo3.socialmeli.service;

import br.com.grupo3.socialmeli.dto.FollowersListSellerDto;
import br.com.grupo3.socialmeli.dto.FollowersListUserDto;
import br.com.grupo3.socialmeli.model.Seller;

import java.util.List;
import java.util.stream.Collectors;

public class FollowersListService {
    final SellerService sellerService;

    public FollowersListService(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    public FollowersListSellerDto getSellerFollowing(Long id) {
        Seller seller = sellerService.getById(id);

        List<FollowersListUserDto> sellerFollowers = seller.getFollowers().stream().map(FollowersListUserDto::new).collect(Collectors.toList());

        return new FollowersListSellerDto(seller.getUserId(), seller.getUserName(), sellerFollowers);
    }

}
