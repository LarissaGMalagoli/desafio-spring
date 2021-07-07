package br.com.grupo3.socialmeli.dto;

import br.com.grupo3.socialmeli.model.Post;
import br.com.grupo3.socialmeli.model.Product;
import br.com.grupo3.socialmeli.model.Seller;

import java.time.LocalDate;

public class PostDto {

    private Long postId;
    private SellerDto sellerDto;
    private Product product;
    private int category;
    private double price;
    private boolean hasPromo;
    private double discount;
    private LocalDate date;

    public PostDto(Post post) {
        this.postId = post.getPostId();
        this.sellerDto = new SellerDto(post.getSeller());
        this.product = post.getProduct();
        this.category = post.getCategory();
        this.price = post.getPrice();
        this.hasPromo = post.isHasPromo();
        this.discount = post.getDiscount();
        this.date = post.getDate();
    }

    public Long getPostId() {
        return postId;
    }

    public SellerDto getSellerDto() {
        return sellerDto;
    }

    public Product getProduct() {
        return product;
    }

    public int getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public boolean isHasPromo() {
        return hasPromo;
    }

    public double getDiscount() {
        return discount;
    }

    public LocalDate getDate() {
        return date;
    }
}