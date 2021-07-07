package br.com.grupo3.socialmeli.repository;


import br.com.grupo3.socialmeli.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
