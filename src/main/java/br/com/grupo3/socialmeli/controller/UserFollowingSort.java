package br.com.grupo3.socialmeli.controller;

import br.com.grupo3.socialmeli.dto.SellerFollowedDto;

import java.util.Comparator;

public enum UserFollowingSort {

    NAME_DESC(Comparator.comparing(SellerFollowedDto::getUserName).reversed()),
    NAME_ASC(Comparator.comparing(SellerFollowedDto::getUserName));

    private final Comparator<SellerFollowedDto> comparator;

    UserFollowingSort(Comparator<SellerFollowedDto> comparator) {
        this.comparator = comparator;
    }

    public Comparator<SellerFollowedDto> getComparator() {
        return comparator;
    }
}
