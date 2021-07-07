package br.com.grupo3.socialmeli.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User extends Person{

    @OneToMany
    private List<Seller> following = new ArrayList<>();

    public User() {

    }


    public List<Seller> getFollowing() {
        return following;
    }

    public void setFollowing(List<Seller> following) {
        this.following = following;
    }
}
