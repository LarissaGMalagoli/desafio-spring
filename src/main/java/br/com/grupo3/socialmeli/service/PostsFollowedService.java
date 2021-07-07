package br.com.grupo3.socialmeli.service;

import br.com.grupo3.socialmeli.controller.PostSort;
import br.com.grupo3.socialmeli.model.Post;
import br.com.grupo3.socialmeli.model.Seller;
import br.com.grupo3.socialmeli.model.User;
import br.com.grupo3.socialmeli.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PostsFollowedService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    private Stream<Post> streamAll(User user){
        return user.getFollowing().stream()
                .map(Seller::getPostList)
                .flatMap(List::stream);
    }

    private Stream<Post> streamLastTwoWeeks(User user){
        return streamAll(user).filter(e -> e.getDate().isAfter(LocalDate.now().minusWeeks(2)));
    }

    private Comparator<Post> getComparator(String order){
        if (order.equals("date_desc"))
            return PostSort.DATA_DESC.getComparator();
        return PostSort.DATA_ASC.getComparator();
    }



    public List<Post> findAllLastTwoWeeks(Long userId, String order) {
        Comparator<Post> comparator = getComparator(order);

        User user = userService.getById(userId);
        return streamLastTwoWeeks(user)
                .sorted(comparator)
                .collect(Collectors.toList());

    }



}
