package br.com.grupo3.socialmeli.controller.UserController;

import br.com.grupo3.socialmeli.dto.FollowersListSellerDto;
import br.com.grupo3.socialmeli.repository.SellerRepository;
import br.com.grupo3.socialmeli.repository.UserRepository;
import br.com.grupo3.socialmeli.service.FollowersListService;
import br.com.grupo3.socialmeli.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FollowersListController {

    @Autowired
    SellerRepository sellerRepository;
    @Autowired
    UserRepository userRepository;

    @Autowired
    SellerService sellerService;

    @Autowired
    FollowersListService followersListService;

    @GetMapping("/users/{userId}/followers/list")
    public FollowersListSellerDto orderSellerFollowers(@PathVariable Long userId, @RequestParam(required = false) String order){
        return followersListService.orderSellerFollowers(userId, order);
    }

}