package br.com.grupo3.socialmeli.controller.form;

import br.com.grupo3.socialmeli.model.Post;
import br.com.grupo3.socialmeli.model.Product;
import br.com.grupo3.socialmeli.model.Seller;
import br.com.grupo3.socialmeli.service.SellerService;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class PostForm {

    @NotNull
    private Long userId;
    @NotNull
    private Product detail;
    @NotNull
    private int category;
    @NotNull
    private double price;
    @NotNull
    private double discount;

    public Post converter(SellerService sellerService){
        Seller seller = sellerService.getById(userId);
        return new Post(seller, detail, category, price, false, 0.0);
    }

    public Post converterPromotionPost(SellerService sellerService){
        Seller seller = sellerService.getById(userId);
        return new Post(seller, detail, category, price, true, discount);
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public void setDetail(Product detail) {
        this.detail = detail;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public void setDiscount(double discount) {
        this.discount = discount;
    }
}