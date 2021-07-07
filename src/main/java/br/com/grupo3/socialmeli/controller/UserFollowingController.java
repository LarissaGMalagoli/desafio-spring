package br.com.grupo3.socialmeli.controller;

import br.com.grupo3.socialmeli.dto.UserFollowingDto;
import br.com.grupo3.socialmeli.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users/")
public class UserFollowingController {

    @GetMapping("{UserID}/followed/list")
    public List<User> getSellers(@PathVariable String UserID) {
        UserFollowingDto userFollowingDto = new UserFollowingDto();
        return null;
    }
}
