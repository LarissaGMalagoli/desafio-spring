package br.com.grupo3.socialmeli.service;

import br.com.grupo3.socialmeli.controller.form.PostForm;
import br.com.grupo3.socialmeli.model.Post;
import br.com.grupo3.socialmeli.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    SellerService sellerService;

    public Post addPost(PostForm postForm){
        Post post = postForm.converter(sellerService);
        postRepository.save(post);
        return post;
    }
    public Post addPromotionPost(PostForm postForm){
        Post post = postForm.converterPromotionPost(sellerService);
        postRepository.save(post);
        return post;
    }
}