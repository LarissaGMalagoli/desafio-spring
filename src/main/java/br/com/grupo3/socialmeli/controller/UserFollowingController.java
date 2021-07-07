package br.com.grupo3.socialmeli.controller;

import br.com.grupo3.socialmeli.dto.UserFollowingDto;
import br.com.grupo3.socialmeli.model.Seller;
import br.com.grupo3.socialmeli.model.User;
import br.com.grupo3.socialmeli.repository.SellerRepository;
import br.com.grupo3.socialmeli.repository.UserRepository;
import br.com.grupo3.socialmeli.service.UserFollowingService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users/")
public class UserFollowingController {

    final UserFollowingService userFollowingService;

    public UserFollowingController(UserFollowingService userFollowingService) {
        this.userFollowingService = userFollowingService;
    }

    @GetMapping("{userID}/followed/list")
    public ResponseEntity<UserFollowingDto> getSellers(@PathVariable Long userID) {
        return ResponseEntity.ok(userFollowingService.getSellerFollowing(userID));
    }
}
