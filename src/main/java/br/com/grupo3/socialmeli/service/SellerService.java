package br.com.grupo3.socialmeli.service;

import br.com.grupo3.socialmeli.config.exceptions.PersonNotFoundException;
import br.com.grupo3.socialmeli.model.Seller;
import br.com.grupo3.socialmeli.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SellerService {

    @Autowired
    SellerRepository sellerRepository;

    public Seller getById(Long id){
        Optional<Seller> sellerOptional = sellerRepository.findById(id);
        if (sellerOptional.isEmpty()) {
            throw new PersonNotFoundException("Seller not found");
        }
        return sellerOptional.get();
    }
}
