package br.com.grupo3.socialmeli.service;

import br.com.grupo3.socialmeli.dto.QuantityProductPromoDto;
import br.com.grupo3.socialmeli.model.Post;
import br.com.grupo3.socialmeli.model.Seller;
import org.springframework.stereotype.Service;

@Service
public class QuantityProductPromoService {

    final SellerService sellerService;

    public QuantityProductPromoService(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    public QuantityProductPromoDto getQuantityProductsPromo(Long id) {
        Seller seller = sellerService.getById(id);
        Long promoProducts_count = seller.getPostList()
                .stream()
                .filter(Post::isHasPromo)
                .count();

        return new QuantityProductPromoDto(seller.getUserId(), seller.getUserName(), promoProducts_count);
    }
}
