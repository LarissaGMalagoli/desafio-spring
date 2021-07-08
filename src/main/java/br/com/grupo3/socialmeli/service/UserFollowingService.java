package br.com.grupo3.socialmeli.service;

import br.com.grupo3.socialmeli.dto.SellerFollowedDto;
import br.com.grupo3.socialmeli.dto.UserFollowingDto;
import br.com.grupo3.socialmeli.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserFollowingService {

    final UserService userService;

    public UserFollowingService(UserService userService) {
        this.userService = userService;
    }

    public UserFollowingDto getSellerFollowing(Long id) {
        User user = userService.getById(id);

        List<SellerFollowedDto> sellerFollowedDto = user.getFollowing()
                .stream()
                .map(SellerFollowedDto::new)
                .collect(Collectors.toList());

        return new UserFollowingDto(user.getUserId(), user.getUserName(), sellerFollowedDto);
    }
}
