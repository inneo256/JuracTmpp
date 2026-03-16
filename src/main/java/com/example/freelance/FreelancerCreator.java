package com.example.freelance;

public class FreelancerCreator extends UserCreator {

    @Override
    public User factoryMethod(String name) {
        return new Freelancer(name);  // создаём конкретного пользователя
    }

    @Override
    protected String getDashboardHtml(User user) {
        // Возвращаем имя HTML-шаблона для фрилансера
        return "freelancer_dashboard";  // будет искать freelancer_dashboard.html в templates
    }
}