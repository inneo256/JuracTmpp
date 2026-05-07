package com.example.freelance.controller;

import com.example.freelance.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.freelance.observer.NotificationService;

@Controller
public class OrderController {

    private final NotificationService notificationService;

    public OrderController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("/create-order")
    public String createOrder(@RequestParam String title,
                              @RequestParam String description,
                              @RequestParam(required = false) Double price,
                              @RequestParam(required = false) String deadline,
                              @RequestParam String skills,
                              Model model) {

        Order.Builder builder = new Order.Builder(title, description);

        if (price != null) builder.price(price);
        if (deadline != null && !deadline.isEmpty()) builder.deadline(deadline);

        Order order = builder.build();

        notificationService.notifyFreelancersAboutOrder(
                title,
                skills,
                price != null ? price.toString() : "не указан"
        );

        model.addAttribute("order", order);
        return "order_result";
    }
}