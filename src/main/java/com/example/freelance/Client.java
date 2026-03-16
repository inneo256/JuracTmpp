package com.example.freelance;

public class Client extends User {

    public Client(String name) {
        super(name);
        this.role = "Client";
    }

    @Override
    public String showDashboard() {
        return "client_dashboard";
    }

    // Специфичные методы для клиента
    public String postOrder() {
        return "Поле для создания заказа: [тут будет ввод]";
    }
}