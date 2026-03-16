package com.example.freelance;

public abstract class User {

    protected String name;   // Имя пользователя
    protected String role;   // Роль: Freelancer или Client

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    // Абстрактный метод для отображения кабинета
    public abstract String showDashboard();
}