package br.com.grupo3.socialmeli.repository;

import br.com.grupo3.socialmeli.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
