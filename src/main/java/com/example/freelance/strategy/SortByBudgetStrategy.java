package com.example.freelance.strategy;

import com.example.freelance.prot.Post;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortByBudgetStrategy implements PostSortStrategy {

    @Override
    public List<Post> sort(List<Post> posts) {
        return posts.stream()
                .sorted(Comparator.comparingDouble(p -> Double.parseDouble(p.getBudget())))
                .collect(Collectors.toList());
    }
}