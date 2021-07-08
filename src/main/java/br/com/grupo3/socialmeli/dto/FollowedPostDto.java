package br.com.grupo3.socialmeli.dto;

import br.com.grupo3.socialmeli.model.Post;
import br.com.grupo3.socialmeli.model.Product;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class FollowedPostDto {

    private final Long postId;
    private final LocalDate date;
    private final Product detail;
    private final int categoria;
    private final double price;



    public FollowedPostDto(Post post) {
        this.postId = post.getPostId();
        this.date = post.getDate();
        this.detail = post.getProduct();
        this.categoria = post.getCategory();
        this.price = post.getPrice();
    }

    public Long getPostId() {
        return postId;
    }

    public LocalDate getDate() {
        return date;
    }

    public Product getDetail() {
        return detail;
    }

    public double getCategoria() {
        return categoria;
    }

    public double getPrice() {
        return price;
    }

    public static List<FollowedPostDto> convert(List<Post> posts){
        return posts.stream().map(FollowedPostDto::new).collect(Collectors.toList());
    }
}
