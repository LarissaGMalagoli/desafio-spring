package br.com.grupo3.socialmeli.dto;


import java.util.List;


public class UserFollowedSellerPostsDto {

    private final Long userId;
    private final List<FollowedPostDto> postsDtos;

    public UserFollowedSellerPostsDto(Long userId, List<FollowedPostDto> posts){
        this.userId = userId;
        postsDtos = posts;
    }

    public Long getUserId() {
        return userId;
    }

    public List<FollowedPostDto> getPostsDtos() {
        return postsDtos;
    }
}
