package com.example.freelance;

public class Freelancer extends User {

    public Freelancer(String name) {
        super(name);
        this.role = "Freelancer";
    }

    @Override
    public String showDashboard() {
        // Название HTML-шаблона
        return "freelancer_dashboard";
    }

    // Можно добавить методы, специфичные для фрилансера
    public String searchOrders() {
        return "Поле поиска заказов: [тут будет ввод]";
    }
}