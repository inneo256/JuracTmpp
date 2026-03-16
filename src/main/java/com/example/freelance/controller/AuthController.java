package com.example.freelance.controller;
import com.example.freelance.Registry.SiteStats;
import com.example.freelance.*;
import com.example.freelance.AbsractFact.Theme;
import com.example.freelance.AbsractFact.ThemeFactory;
import com.example.freelance.prot.PostRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @GetMapping("/auth")
    public String authPage() {
        return "auth";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String name,
                               @RequestParam String type,
                               Model model) {
        UserCreator creator;

        if (type.equalsIgnoreCase("freelancer")) {
            creator = new FreelancerCreator();
            SiteStats.getInstance().addFreelancer();
        } else if (type.equalsIgnoreCase("client")) {
            creator = new ClientCreator();
            SiteStats.getInstance().addClient();
        } else throw new IllegalArgumentException("Unknown type: " + type);

        Theme pinkTheme = ThemeFactory.getFactory("pink").createTheme();
        Theme darkTheme = ThemeFactory.getFactory("dark").createTheme();

        model.addAttribute("name", name);
        model.addAttribute("pinkTheme", pinkTheme);
        model.addAttribute("darkTheme", darkTheme);
        model.addAttribute("posts", PostRegistry.getAllPosts()); // ← посты из реестра

        return creator.createDashboard(name);
    }
}