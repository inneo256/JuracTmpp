package com.example.freelance.prot;

public class FreelancerPost extends Post {

    public FreelancerPost(String title, String description, String budget, String skills) {
        super(title, description, budget, skills);
    }

    @Override
    public Prototype clonePost() {
        // Возвращаем копию самого себя
        return new FreelancerPost(
                "Копия: " + this.title,
                this.description,
                this.budget,
                this.skills
        );
    }
}