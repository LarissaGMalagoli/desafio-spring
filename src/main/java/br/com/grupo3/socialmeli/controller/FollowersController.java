package br.com.grupo3.socialmeli.controller;

import br.com.grupo3.socialmeli.dto.FollowersDto;
import br.com.grupo3.socialmeli.model.Seller;
import br.com.grupo3.socialmeli.repository.SellerRepository;
import br.com.grupo3.socialmeli.repository.UserRepository;
import br.com.grupo3.socialmeli.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FollowersController {

    @Autowired
    SellerService sellerService;

    @GetMapping("/users/{userId}/followers/count")
    public FollowersDto getFollowersCount(@PathVariable Long userId){
        Seller seller = sellerService.getById(userId);
        return new FollowersDto(seller);
    }
}
