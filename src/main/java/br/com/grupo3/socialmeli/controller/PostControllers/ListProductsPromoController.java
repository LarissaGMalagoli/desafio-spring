package br.com.grupo3.socialmeli.controller.PostControllers;

import br.com.grupo3.socialmeli.dto.ListProductsPromoDto;
import br.com.grupo3.socialmeli.service.ListProductsPromoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products/")
public class ListProductsPromoController {


    final ListProductsPromoService listProductsPromoService;

    public ListProductsPromoController(ListProductsPromoService listProductsPromoService) {
        this.listProductsPromoService = listProductsPromoService;
    }

    @GetMapping("{userID}/list")
    public ResponseEntity<ListProductsPromoDto> getListProductsPromo(@PathVariable Long userID) {
        return ResponseEntity.ok(listProductsPromoService.getListProductsPromo(userID));
    }
}