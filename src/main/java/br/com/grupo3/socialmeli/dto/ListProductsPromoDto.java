package br.com.grupo3.socialmeli.dto;

import java.util.List;

public class ListProductsPromoDto {
    private Long userId;
    private String userName;
    private List<PostPromoDto> posts;

    public ListProductsPromoDto(Long userId, String userName, List<PostPromoDto> posts) {
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

    public List<PostPromoDto> getPosts() {
        return posts;
    }
}
