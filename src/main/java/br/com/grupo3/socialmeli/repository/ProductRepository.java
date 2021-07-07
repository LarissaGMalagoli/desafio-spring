package br.com.grupo3.socialmeli.repository;


import br.com.grupo3.socialmeli.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
