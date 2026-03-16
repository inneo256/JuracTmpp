package com.example.freelance.prot;

import java.util.ArrayList;
import java.util.List;

public class PostRegistry {

    // Готовые примеры заказов — вместо БД
    private static final List<Post> posts = new ArrayList<>();

    static {
        posts.add(new FreelancerPost(
                "Создать лендинг",
                "Нужен сайт для стартапа. Срок — 5 дней.",
                "300$",
                "HTML, CSS, JavaScript"
        ));
        posts.add(new FreelancerPost(
                "Дизайн логотипа",
                "Разработать логотип для IT-компании.",
                "100$",
                "Figma, Illustrator"
        ));
        posts.add(new ClientPost(
                "SEO продвижение",
                "Оптимизация сайта для поисковых систем. Срок — 10 дней.",
                "200$",
                "SEO, Google Analytics"
        ));
    }

    public static List<Post> getAllPosts() {
        return posts;
    }

    // Клонировать пост по индексу
    public static Post clonePost(int index) {
        return (Post) posts.get(index).clonePost();
    }
}