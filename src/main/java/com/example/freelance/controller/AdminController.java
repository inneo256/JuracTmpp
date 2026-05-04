package com.example.freelance.controller;

import com.example.freelance.AbsractFact.ThemeFactory;
import com.example.freelance.Registry.SiteStats;
import com.example.freelance.composite.FreelancerCompositeService;
import com.example.freelance.composite.FreelancerGroup;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    private final FreelancerCompositeService freelancerCompositeService;

    public AdminController(FreelancerCompositeService freelancerCompositeService) {
        this.freelancerCompositeService = freelancerCompositeService;
    }

    @GetMapping("/admin-login")
    public String adminLoginPage() {
        return "admin_login";
    }

    @GetMapping("/admin")
    public String adminPage(Model model) {
        SiteStats stats = SiteStats.getInstance();

        FreelancerGroup root = freelancerCompositeService.buildTree();

        model.addAttribute("freelancerCount", stats.getFreelancerCount());
        model.addAttribute("clientCount", stats.getClientCount());
        model.addAttribute("orderCount", stats.getOrderCount());
        model.addAttribute("cloneCount", stats.getCloneCount());
        model.addAttribute("totalUsers", stats.getTotalUsers());

        model.addAttribute("pinkTheme", ThemeFactory.getFactory("pink").createTheme());
        model.addAttribute("darkTheme", ThemeFactory.getFactory("dark").createTheme());

        model.addAttribute("total", root.count());
        model.addAttribute("stats", root.countBySkill());
        model.addAttribute("treeText", freelancerCompositeService.buildTreeText());

        return "admin_dashboard";
    }
}