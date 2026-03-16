package com.example.freelance.controller;

import com.example.freelance.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class OrderController {

    @PostMapping("/create-order")
    public String createOrder(@RequestParam String title,
                              @RequestParam String description,
                              @RequestParam(required = false) Double price,
                              @RequestParam(required = false) String deadline,
                              Model model) {

        // Builder строит заказ — необязательные поля добавляем только если они есть
        Order.Builder builder = new Order.Builder(title, description);

        if (price != null) builder.price(price);
        if (deadline != null && !deadline.isEmpty()) builder.deadline(deadline);

        Order order = builder.build();

        model.addAttribute("order", order);
        return "order_result"; // страница с результатом
    }
}