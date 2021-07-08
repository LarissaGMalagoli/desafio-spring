package br.com.grupo3.socialmeli.service;

import br.com.grupo3.socialmeli.model.Seller;
import br.com.grupo3.socialmeli.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowService {

    @Autowired
    UserService userService;
    @Autowired
    SellerService sellerService;

    //userService.getById(userId),sellerService.getById(userIdToFollow)

    public void follow(Long user, Long seller){
        User usuario = userService.getById(user);
        Seller vendedor = sellerService.getById(seller);
        addFollowing(usuario, vendedor);
//        addFollower(usuario, vendedor);
    }

    private void addFollower(User usuario, Seller vendedor){
        List<User> listaFollowers = vendedor.getFollowers();
        listaFollowers.add(usuario);
        //vendedor.setFollowersCount(vendedor.getFollowersCount()+1);
    }

    private void addFollowing(User usuario, Seller vendedor){
        List<Seller> listaFollowed = usuario.getFollowing();
        listaFollowed.add(vendedor);
        vendedor.setFollowersCount(vendedor.getFollowersCount()+1);
    }
}
