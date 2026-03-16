package com.example.freelance.controller;

import com.example.freelance.prot.Post;
import com.example.freelance.prot.PostRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    @GetMapping("/clone-post")
    public String clonePost(@RequestParam int index,
                            @RequestParam String name,
                            Model model) {
        // Прототип клонирует пост
        Post cloned = PostRegistry.clonePost(index);

        model.addAttribute("clonedPost", cloned);
        model.addAttribute("name", name);
        model.addAttribute("pinkTheme",
                com.example.freelance.AbsractFact.ThemeFactory.getFactory("pink").createTheme());
        model.addAttribute("darkTheme",
                com.example.freelance.AbsractFact.ThemeFactory.getFactory("dark").createTheme());
        model.addAttribute("posts", PostRegistry.getAllPosts());

        return "freelancer_dashboard";
    }
}