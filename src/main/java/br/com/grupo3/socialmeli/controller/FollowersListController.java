package br.com.grupo3.socialmeli.controller;

import br.com.grupo3.socialmeli.dto.FollowersListSellerDto;
import br.com.grupo3.socialmeli.model.Seller;
import br.com.grupo3.socialmeli.model.User;
import br.com.grupo3.socialmeli.repository.SellerRepository;
import br.com.grupo3.socialmeli.repository.UserRepository;
import br.com.grupo3.socialmeli.service.FollowersListService;
import br.com.grupo3.socialmeli.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/followerslistcontroller")
public class FollowersListController {

    @Autowired
    SellerRepository sellerRepository;
    @Autowired
    UserRepository userRepository;

    @Autowired
    SellerService sellerService;

    @Autowired
    FollowersListService followersListService;

    @GetMapping("/teste")
    @Transactional
    public ResponseEntity<?> testAddEntities(){
        User user = new User();
        Seller seller = new Seller();
        userRepository.save(user);
        sellerRepository.save(seller);
        user.getFollowing().add(seller);
        seller.setFollowersCount(1);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{userId}/followers/list")
    public FollowersListSellerDto getFollowersCount(@PathVariable Long userId){
        return followersListService.getSellerFollowing(userId);
    }

    @GetMapping("/sellers")
    public List<Seller> findSellers(){
        return sellerRepository.findAll();
    }

    @GetMapping("/users")
    public List<User> findUsers(){
        return userRepository.findAll();
    }


}
