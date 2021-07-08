package br.com.grupo3.socialmeli.service;

import br.com.grupo3.socialmeli.controller.FollowersListSort;
import br.com.grupo3.socialmeli.dto.FollowersListSellerDto;
import br.com.grupo3.socialmeli.dto.FollowersListUserDto;
import br.com.grupo3.socialmeli.model.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FollowersListService {

    @Autowired
    SellerService sellerService;

    private Comparator<FollowersListUserDto> getComparator(String order){
        if (order == null)
            return FollowersListSort.ASC.getComparator();
        if (order.equals("name_asc"))
            return FollowersListSort.ASC.getComparator();
        if (order.equals("name_desc"))
            return FollowersListSort.DESC.getComparator();
        return FollowersListSort.ASC.getComparator();
    }

    public List<FollowersListUserDto> getFollowersList(Seller seller, Comparator<FollowersListUserDto> comparator){
        return seller.getFollowers().stream()
                .map(FollowersListUserDto::new)
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    public FollowersListSellerDto orderSellerFollowers(Long id, String order) {
        Seller seller = sellerService.getById(id);
        return new FollowersListSellerDto(seller.getUserId(), seller.getUserName(), getFollowersList(seller, getComparator(order)));
    }

}
