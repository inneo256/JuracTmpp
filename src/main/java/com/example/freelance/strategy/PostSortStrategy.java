package com.example.freelance.strategy;

import com.example.freelance.prot.Post;
import java.util.List;

public interface PostSortStrategy {
    List<Post> sort(List<Post> posts);
}