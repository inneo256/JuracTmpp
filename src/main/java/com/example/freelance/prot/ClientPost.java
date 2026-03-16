package com.example.freelance.prot;

public class ClientPost extends Post {

    public ClientPost(String title, String description, String budget, String skills) {
        super(title, description, budget, skills);
    }

    @Override
    public Prototype clonePost() {
        return new ClientPost(
                "Копия: " + this.title,
                this.description,
                this.budget,
                this.skills
        );
    }
}