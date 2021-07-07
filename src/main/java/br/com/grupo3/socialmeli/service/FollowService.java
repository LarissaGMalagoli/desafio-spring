package br.com.grupo3.socialmeli.service;

import br.com.grupo3.socialmeli.model.Seller;
import br.com.grupo3.socialmeli.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowService {

    public void follow(User usuario, Seller vendedor){
        addFollowing(usuario, vendedor);
        addFollowing(usuario, vendedor);
    }

    private void addFollower(User usuario, Seller vendedor){
        List<User> listaFollowers = vendedor.getFollowers();
        listaFollowers.add(usuario);
    }

    private void addFollowing(User usuario, Seller vendedor){
        List<Seller> listaFollowed = usuario.getFollowing();
        listaFollowed.add(vendedor);
    }
}
