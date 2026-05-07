package com.example.freelance.strategy;

import com.example.freelance.prot.Post;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortByTitleStrategy implements PostSortStrategy {

    @Override
    public List<Post> sort(List<Post> posts) {
        return posts.stream()
                .sorted(Comparator.comparing(Post::getTitle))
                .collect(Collectors.toList());
    }
}