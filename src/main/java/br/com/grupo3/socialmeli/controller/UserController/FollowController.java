package br.com.grupo3.socialmeli.controller.UserController;

import br.com.grupo3.socialmeli.dto.UserDto;
import br.com.grupo3.socialmeli.model.Seller;
import br.com.grupo3.socialmeli.model.User;
import br.com.grupo3.socialmeli.repository.SellerRepository;
import br.com.grupo3.socialmeli.repository.UserRepository;
import br.com.grupo3.socialmeli.service.FollowService;
import br.com.grupo3.socialmeli.service.SellerService;
import br.com.grupo3.socialmeli.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.util.Optional;


@RestController
public class FollowController {

    @Autowired
    SellerRepository sellerRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    FollowService followService;
    @Autowired
    UserService userService;
    @Autowired
    SellerService sellerService;

    @Transactional
    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<UserDto> followUser(@PathVariable Long userId, @PathVariable Long userIdToFollow, UriComponentsBuilder uriBuilder ){

        followService.follow(userId, userIdToFollow);

        return ResponseEntity.ok().body(new UserDto(userService.getById(userId)));
    }

    @Transactional
    @PostMapping("/users/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<UserDto> unFollowUser(@PathVariable Long userId, @PathVariable Long userIdToUnfollow, UriComponentsBuilder uriBuilder ){

        followService.unFollow(userId, userIdToUnfollow);

        return ResponseEntity.ok().body(new UserDto(userService.getById(userId)));
    }
}