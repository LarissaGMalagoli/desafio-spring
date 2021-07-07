package br.com.grupo3.socialmeli.service;

import br.com.grupo3.socialmeli.dto.ListProductsPromoDto;
import br.com.grupo3.socialmeli.dto.PostPromoDto;
import br.com.grupo3.socialmeli.model.Post;
import br.com.grupo3.socialmeli.model.Seller;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListProductsPromoService {

    final SellerService sellerService;

    public ListProductsPromoService(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    public ListProductsPromoDto getListProductsPromo(Long id) {
        Seller seller = sellerService.getById(id);

        List<PostPromoDto> posts = seller.getPostList()
                .stream()
                .filter(Post::isHasPromo)
                .map(PostPromoDto::new)
                .collect(Collectors.toList());

        return new ListProductsPromoDto(seller.getUserId(), seller.getUserName(), posts);
    }
}
