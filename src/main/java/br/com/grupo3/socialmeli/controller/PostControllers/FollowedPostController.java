package br.com.grupo3.socialmeli.controller.PostControllers;

import br.com.grupo3.socialmeli.dto.FollowedPostDto;
import br.com.grupo3.socialmeli.dto.UserFollowedSellerPostsDto;
import br.com.grupo3.socialmeli.model.Post;
import br.com.grupo3.socialmeli.service.PostsFollowedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class FollowedPostController {

    @Autowired
    PostsFollowedService postsFollowedService;


    @GetMapping("/products/followed/{userId}/list")
    public ResponseEntity<UserFollowedSellerPostsDto> getAllLastTwoWeeks(@PathVariable Long userId,
                                                                               @RequestParam(required = false) String order) {

        List<Post> posts = postsFollowedService.findAllLastTwoWeeks(userId, order);
        List<FollowedPostDto> followedPostDtos = FollowedPostDto.convert(posts);
        return ResponseEntity.ok(new UserFollowedSellerPostsDto(userId, followedPostDtos));

    }
}