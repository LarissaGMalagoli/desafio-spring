package br.com.grupo3.socialmeli.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Seller extends Person{

    private int followersCount;
    @OneToMany
    private List<Post> postList;
    @ManyToMany
    private List<User> followers;

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