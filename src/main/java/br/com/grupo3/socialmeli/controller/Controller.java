package br.com.grupo3.socialmeli.controller;

import br.com.grupo3.socialmeli.model.Seller;
import br.com.grupo3.socialmeli.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    SellerRepository sellerRepository;

    @GetMapping("/teste")
    public void teste(){
        Seller seller = new Seller();
        sellerRepository.save(seller);
    }
}
