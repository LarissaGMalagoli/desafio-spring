package br.com.grupo3.socialmeli.controller.form;

import br.com.grupo3.socialmeli.model.Post;
import br.com.grupo3.socialmeli.model.Product;
import br.com.grupo3.socialmeli.model.Seller;
import br.com.grupo3.socialmeli.repository.PostRepository;
import br.com.grupo3.socialmeli.repository.SellerRepository;
import br.com.grupo3.socialmeli.service.SellerService;
import br.com.grupo3.socialmeli.service.UserService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

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

    public Post converter(SellerService sellerService){
        Seller seller = sellerService.getById(userId);
        return new Post(seller, detail, category, price, hasPromo, discount);
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