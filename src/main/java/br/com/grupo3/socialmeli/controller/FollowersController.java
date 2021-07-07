package br.com.grupo3.socialmeli.controller;

import br.com.grupo3.socialmeli.dto.FollowersDto;
import br.com.grupo3.socialmeli.model.Seller;
import br.com.grupo3.socialmeli.model.User;
import br.com.grupo3.socialmeli.repository.SellerRepository;
import br.com.grupo3.socialmeli.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fcontroller")
public class FollowersController {

    @Autowired
    SellerRepository sellerRepository;
    @Autowired
    UserRepository userRepository;

    @GetMapping("/teste")
    @Transactional
    public ResponseEntity<?> teste(){
        User user = new User();

        Seller seller = new Seller();

        userRepository.save(user);
        sellerRepository.save(seller);
        user.getFollowing().add(seller);
        seller.setFollowersCount(1);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{userId}/followers/count")
    public FollowersDto getFollowersCount(@PathVariable Long userId){
        Optional<Seller> optionalSeller = sellerRepository.findById(userId);

        if (optionalSeller.isEmpty()){
            return null;
        }

        Seller seller = optionalSeller.get();
        return new FollowersDto(seller);
    }

    @GetMapping("/sellers")
    public List<Seller> acha(){
        return sellerRepository.findAll();
    }
}
