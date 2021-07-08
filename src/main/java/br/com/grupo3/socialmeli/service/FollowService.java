package br.com.grupo3.socialmeli.service;

import br.com.grupo3.socialmeli.config.exceptions.AlreadyFollowingException;
import br.com.grupo3.socialmeli.config.exceptions.NotFollowingException;
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
    }

    public void unFollow(Long user, Long seller){
        User usuario = userService.getById(user);
        Seller vendedor = sellerService.getById(seller);
        removeFollowing(usuario, vendedor);
    }

    private void removeFollowing(User usuario, Seller vendedor){
        List<Seller> listaFollowed = usuario.getFollowing();
        if (!listaFollowed.contains(vendedor))
            throw new NotFollowingException("This user isn't following the target seller");
        listaFollowed.remove(vendedor);
        vendedor.setFollowersCount(vendedor.getFollowersCount()-1);
    }

    private void addFollowing(User usuario, Seller vendedor){
        List<Seller> listaFollowed = usuario.getFollowing();
        if (listaFollowed.contains(vendedor))
            throw new AlreadyFollowingException("This user is already following the seller");
        listaFollowed.add(vendedor);
        vendedor.setFollowersCount(vendedor.getFollowersCount()+1);
    }
}
