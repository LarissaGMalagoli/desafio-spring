package br.com.grupo3.socialmeli.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class PostmanController {

    String postmanUrl = "https://documenter.getpostman.com/view/16324866/Tzm5Jx4Z";

    @RequestMapping
    public RedirectView postman(){
        return new RedirectView(postmanUrl);
    }
}
