package br.com.grupo3.socialmeli.controller.form;

import br.com.grupo3.socialmeli.model.Post;
import br.com.grupo3.socialmeli.model.Product;
import br.com.grupo3.socialmeli.model.Seller;
import br.com.grupo3.socialmeli.repository.PostRepository;
import br.com.grupo3.socialmeli.repository.SellerRepository;
import com.sun.istack.NotNull;

public class PostForm {

    //Nao tem ID do user/post nem createdAt no payload, pois os ID's sao gerados automaticamente pelo banco, e o date é um date.now();
    @NotNull
    private Long userId;
    private Product detail;
    private int category;
    private double price;
    @NotNull
    private Boolean hasPromo;
    private double discount;

    public Post converter(SellerRepository sellerRepository){
        Seller seller = sellerRepository.getById(userId);
        return new Post(seller, detail, category, price, hasPromo, discount);
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

    public void setHasPromo(Boolean hasPromo) {
        this.hasPromo = hasPromo;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}