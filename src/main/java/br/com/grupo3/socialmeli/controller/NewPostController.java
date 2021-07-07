package br.com.grupo3.socialmeli.controller;

import br.com.grupo3.socialmeli.controller.form.PostForm;
import br.com.grupo3.socialmeli.model.Post;
import br.com.grupo3.socialmeli.repository.PostRepository;
import br.com.grupo3.socialmeli.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
public class NewPostController {

    @Autowired
    PostRepository postRepository;
    @Autowired
    SellerRepository sellerRepository;

    @PostMapping("/products/newpost")
    public ResponseEntity<Post> newPost(@RequestBody @Valid PostForm postForm, UriComponentsBuilder uriBuilder){
        Post post = postForm.converter(sellerRepository);
        postRepository.save(post);
        URI uri = uriBuilder.path("/post/{id}").buildAndExpand(post.getPostId()).toUri();
        postRepository.save(post);
        return ResponseEntity.created(uri).body(post);
    }
}