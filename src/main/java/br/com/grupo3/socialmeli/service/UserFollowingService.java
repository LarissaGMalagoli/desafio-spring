package br.com.grupo3.socialmeli.service;

import br.com.grupo3.socialmeli.controller.UserFollowingSort;
import br.com.grupo3.socialmeli.dto.SellerFollowedDto;
import br.com.grupo3.socialmeli.dto.UserFollowingDto;
import br.com.grupo3.socialmeli.model.User;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserFollowingService {

    final UserService userService;

    public UserFollowingService(UserService userService) {
        this.userService = userService;
    }

    public UserFollowingDto getSellerFollowing(Long id, String order) {
        Comparator<SellerFollowedDto> comparator = getComparator(order);

        User user = userService.getById(id);

        List<SellerFollowedDto> sellerFollowedDto = user.getFollowing()
                .stream()
                .map(SellerFollowedDto::new)
                .sorted(comparator)
                .collect(Collectors.toList());

        return new UserFollowingDto(user.getUserId(), user.getUserName(), sellerFollowedDto);
    }

    private Comparator<SellerFollowedDto> getComparator(String order) {
        if (order == null) {
            return UserFollowingSort.NAME_ASC.getComparator();
        }
        if (order.equals("name_desc")) {
            return UserFollowingSort.NAME_DESC.getComparator();
        }
        return UserFollowingSort.NAME_ASC.getComparator();
    }



}
