package br.com.grupo3.socialmeli.service;

import br.com.grupo3.socialmeli.config.exceptions.PersonNotFoundException;
import br.com.grupo3.socialmeli.model.User;
import br.com.grupo3.socialmeli.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User getById(Long id){
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new PersonNotFoundException("User not found");
        }
        return optionalUser.get();
    }
}
