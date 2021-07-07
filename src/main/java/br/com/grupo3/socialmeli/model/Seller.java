package br.com.grupo3.socialmeli.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Seller extends Person{

    private int followersCount = 0;
    @OneToMany(mappedBy = "seller")
    private List<Post> postList = new ArrayList<>();
    @ManyToMany
    private List<User> followers = new ArrayList<>();

    public Seller() {
    }


    public int getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(int followersCount) {
        this.followersCount = followersCount;
    }

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }

    public List<User> getFollowers() {
        return followers;
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }


}
