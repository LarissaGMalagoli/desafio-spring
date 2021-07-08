package br.com.grupo3.socialmeli.controller;
import br.com.grupo3.socialmeli.dto.FollowersListUserDto;

import java.util.Comparator;

public enum FollowersListSort {

    DESC(Comparator.comparing(FollowersListUserDto::getUserName).reversed()),
    ASC(Comparator.comparing(FollowersListUserDto::getUserName));

    private final Comparator<FollowersListUserDto> comparator;

    FollowersListSort(Comparator<FollowersListUserDto> comparator) {
        this.comparator = comparator;
    }

    public Comparator<FollowersListUserDto> getComparator() {
        return comparator;
    }
}