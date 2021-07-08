package br.com.grupo3.socialmeli.controller;

import br.com.grupo3.socialmeli.dto.UserFollowingDto;
import br.com.grupo3.socialmeli.service.UserFollowingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users/")
public class UserFollowingController {

    final UserFollowingService userFollowingService;

    public UserFollowingController(UserFollowingService userFollowingService) {
        this.userFollowingService = userFollowingService;
    }

    @GetMapping("{userID}/followed/list")
    public ResponseEntity<UserFollowingDto> getSellers(@PathVariable Long userID,
                                                       @RequestParam(required = false) String order) {
        return ResponseEntity.ok(userFollowingService.getSellerFollowing(userID, order));
    }
}
