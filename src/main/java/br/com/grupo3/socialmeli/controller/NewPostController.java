package br.com.grupo3.socialmeli.controller;

import br.com.grupo3.socialmeli.controller.form.PostForm;
import br.com.grupo3.socialmeli.dto.PostDto;
import br.com.grupo3.socialmeli.model.Post;
import br.com.grupo3.socialmeli.repository.PostRepository;
import br.com.grupo3.socialmeli.repository.SellerRepository;
import br.com.grupo3.socialmeli.service.PostService;
import br.com.grupo3.socialmeli.service.SellerService;
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
    SellerService sellerService;

    @Autowired
    PostService postService;

    @PostMapping("/products/newpost")
    public ResponseEntity<PostDto> newPost(@RequestBody @Valid PostForm postForm, UriComponentsBuilder uriBuilder){
        Post post = postForm.converter(sellerService);
        postRepository.save(post);
        //TODO: service que add o post que a gente acabou de criar;
        URI uri = uriBuilder.path("/post/{id}").buildAndExpand(post.getPostId()).toUri();
        return ResponseEntity.created(uri).body(new PostDto(post));
    }

    @PostMapping("/products/newpromopost")
    public ResponseEntity<PostDto> newPromoPost(@RequestBody @Valid PostForm postForm, UriComponentsBuilder uriBuilder){
        Post post = postForm.converterPromotionPost(sellerService);
        postRepository.save(post);
        URI uri = uriBuilder.path("/post/{id}").buildAndExpand(post.getPostId()).toUri();
        return ResponseEntity.created(uri).body(new PostDto(post));
    }
}