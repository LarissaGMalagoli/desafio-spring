package br.com.grupo3.socialmeli.repository;

import br.com.grupo3.socialmeli.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Long> {
}
