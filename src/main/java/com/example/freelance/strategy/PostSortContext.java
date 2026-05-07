package com.example.freelance.strategy;

import com.example.freelance.prot.Post;
import java.util.List;

public class PostSortContext {

    private PostSortStrategy strategy;

    public void setStrategy(PostSortStrategy strategy) {
        this.strategy = strategy;
    }

    public List<Post> execute(List<Post> posts) {
        return strategy.sort(posts);
    }
}