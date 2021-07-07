package br.com.grupo3.socialmeli.dto;

import br.com.grupo3.socialmeli.model.Post;

import java.util.List;

public class ListProductsPromoDto {
    private Long userId;
    private String userName;
    private List<Post> posts;

    public ListProductsPromoDto(Long userId, String userName, List<Post> posts) {
        this.userId = userId;
        this.userName = userName;
        this.posts = posts;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public List<Post> getPosts() {
        return posts;
    }
}
