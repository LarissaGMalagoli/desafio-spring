package br.com.grupo3.socialmeli.controller;

import br.com.grupo3.socialmeli.dto.QuantityProductPromoDto;
import br.com.grupo3.socialmeli.service.QuantityProductPromoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class QuantityProductsPromoController {

    final QuantityProductPromoService quantityProductPromoService;

    public QuantityProductsPromoController(QuantityProductPromoService quantityProductPromoService) {
        this.quantityProductPromoService = quantityProductPromoService;
    }

    @GetMapping("/{userID}/countPromo/")
    public QuantityProductPromoDto getQuantityProducts(@RequestParam Long userID) {
        return quantityProductPromoService.getQuantityProductsPromo(userID);
    }
}
