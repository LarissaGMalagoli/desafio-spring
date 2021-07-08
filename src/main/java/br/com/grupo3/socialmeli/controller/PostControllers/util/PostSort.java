package br.com.grupo3.socialmeli.controller.PostControllers.util;

import br.com.grupo3.socialmeli.model.Post;

import java.util.Comparator;

public enum PostSort {

    DATA_DESC(Comparator.comparing(Post::getDate).reversed()),
    DATA_ASC(Comparator.comparing(Post::getDate));

    private final Comparator<Post> comparator;

    PostSort(Comparator<Post> comparator) {
        this.comparator = comparator;
    }

    public Comparator<Post> getComparator() {
        return comparator;
    }
}