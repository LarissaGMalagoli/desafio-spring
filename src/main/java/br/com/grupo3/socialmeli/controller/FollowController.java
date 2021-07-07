package br.com.grupo3.socialmeli.controller;

import br.com.grupo3.socialmeli.dto.UserDto;
import br.com.grupo3.socialmeli.model.Seller;
import br.com.grupo3.socialmeli.model.User;
import br.com.grupo3.socialmeli.repository.SellerRepository;
import br.com.grupo3.socialmeli.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@RestController
public class FollowController {

    @Autowired
    SellerRepository sellerRepository;
    @Autowired
    UserRepository userRepository;

    @Transactional
    @PostMapping("/users/{userId}/follow/{userIdToFollow}}")
    public ResponseEntity<UserDto> followUser(@PathVariable("userId") Long userId, @PathVariable("userIdToFollow") Long userIdToFollow, UriComponentsBuilder uriBuilder ){
        Optional<User> optUsuario = userRepository.findById(userId);
        Optional<Seller> optVendedor = sellerRepository.findById(userIdToFollow);
        if (optUsuario.isEmpty() && optVendedor.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        User usuario = userRepository.getById(userId);
        Seller vendedor = sellerRepository.getById(userIdToFollow);
        List<User> listaFollowers = vendedor.getFollowers();
        List<Seller> listaFollowed = usuario.getFollowing();
        listaFollowers.add(usuario);
        listaFollowed.add(vendedor);
        return ResponseEntity.ok().body(new UserDto(usuario));
    }
}
