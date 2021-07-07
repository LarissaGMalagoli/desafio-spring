package br.com.grupo3.socialmeli.controller.form;

import br.com.grupo3.socialmeli.model.Post;
import br.com.grupo3.socialmeli.model.Product;
import br.com.grupo3.socialmeli.model.Seller;
import br.com.grupo3.socialmeli.repository.PostRepository;
import br.com.grupo3.socialmeli.repository.SellerRepository;
import com.sun.istack.NotNull;

import javax.validation.constraints.NotEmpty;
import java.util.Optional;

public class PostForm {

    @NotNull
    private Long userId;
    private Product detail;
    private int category;
    private double price;
    @NotNull
    private Boolean hasPromo;
    private double discount;
    public Post converter(SellerRepository sellerRepository){
        Optional<Seller> seller = sellerRepository.findById(userId);
        if(seller.isEmpty()){
            throw new RuntimeException("User not found.");
        }
        return new Post(seller.get(), detail, category, price, hasPromo, discount);
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

    public void setHasPromo(Boolean hasPromo) {
        this.hasPromo = hasPromo;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}