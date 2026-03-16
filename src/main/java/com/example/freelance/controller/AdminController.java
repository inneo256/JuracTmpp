package com.example.freelance.controller;

import com.example.freelance.AbsractFact.ThemeFactory;
import com.example.freelance.Registry.SiteStats;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/admin-login")
    public String adminLoginPage() {
        return "admin_login";
    }

    @GetMapping("/admin")
    public String adminPage(Model model) {
        SiteStats stats = SiteStats.getInstance();
        model.addAttribute("freelancerCount", stats.getFreelancerCount());
        model.addAttribute("clientCount", stats.getClientCount());
        model.addAttribute("orderCount", stats.getOrderCount());
        model.addAttribute("cloneCount", stats.getCloneCount());
        model.addAttribute("totalUsers", stats.getTotalUsers());
        model.addAttribute("pinkTheme", ThemeFactory.getFactory("pink").createTheme());
        model.addAttribute("darkTheme", ThemeFactory.getFactory("dark").createTheme());
        return "admin_dashboard";
    }
}