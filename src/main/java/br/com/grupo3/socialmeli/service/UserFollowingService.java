package br.com.grupo3.socialmeli.service;

import br.com.grupo3.socialmeli.dto.SellerFollowedDto;
import br.com.grupo3.socialmeli.dto.UserFollowingDto;
import br.com.grupo3.socialmeli.model.User;
import br.com.grupo3.socialmeli.repository.UserRepository;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserFollowingService {

    final UserRepository userRepository;

    public UserFollowingService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserFollowingDto getSellerFollowing(Long id) throws NotFoundException {

        Optional<User> user = userRepository.findById(id);

        if (user.isEmpty()) {
            throw new NotFoundException("User not found");
        }

        List<SellerFollowedDto> sellerFollowedDto = user.get().getFollowing()
                .stream()
                .map(SellerFollowedDto::new)
                .collect(Collectors.toList());

        return new UserFollowingDto(user.get().getUserId(), user.get().getUserName(), sellerFollowedDto);

    }
}
