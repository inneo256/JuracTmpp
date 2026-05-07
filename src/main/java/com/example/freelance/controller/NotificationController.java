package com.example.freelance.controller;

import com.example.freelance.observer.NotificationStorage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class NotificationController {

    @GetMapping("/notifications")
    public String notifications(@RequestParam String name, Model model) {

        model.addAttribute("notifications",
                NotificationStorage.getNotifications(name));

        model.addAttribute("name", name);

        return "notifications";
    }
}