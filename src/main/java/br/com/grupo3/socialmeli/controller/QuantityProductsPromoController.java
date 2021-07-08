package br.com.grupo3.socialmeli.controller;

import br.com.grupo3.socialmeli.dto.QuantityProductPromoDto;
import br.com.grupo3.socialmeli.service.QuantityProductPromoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products/")
public class QuantityProductsPromoController {

    final QuantityProductPromoService quantityProductPromoService;

    public QuantityProductsPromoController(QuantityProductPromoService quantityProductPromoService) {
        this.quantityProductPromoService = quantityProductPromoService;
    }

    @GetMapping("{userID}/countPromo")
    public ResponseEntity<QuantityProductPromoDto> getQuantityProducts(@PathVariable Long userID) {
        return ResponseEntity.ok(quantityProductPromoService.getQuantityProductsPromo(userID));
    }
}
