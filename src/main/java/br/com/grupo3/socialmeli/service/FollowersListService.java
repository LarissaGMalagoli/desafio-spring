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

    public FollowersListService(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    public FollowersListSellerDto getSellerFollowers(Long id) {
        Seller seller = sellerService.getById(id);

        List<FollowersListUserDto> sellerFollowers = seller.getFollowers().stream().map(FollowersListUserDto::new).collect(Collectors.toList());

        return new FollowersListSellerDto(seller.getUserId(), seller.getUserName(), sellerFollowers);
    }

    private Comparator<FollowersListUserDto> getComparator(String order){
        if (order == null)
            return FollowersListSort.ASC.getComparator();
        if (order.equals("desc"))
            return FollowersListSort.DESC.getComparator();
        return FollowersListSort.ASC.getComparator();
    }

    public FollowersListSellerDto orderSellerFollowers(Long id, String order) {
        Comparator<FollowersListUserDto> comparator = getComparator(order);
        Seller seller = sellerService.getById(id);

        List<FollowersListUserDto> sellerFollowers = seller.getFollowers().stream().map(FollowersListUserDto::new).sorted(comparator).collect(Collectors.toList());
        return new FollowersListSellerDto(seller.getUserId(), seller.getUserName(), sellerFollowers);
    }

}
