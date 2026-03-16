package com.example.freelance.prot;

public abstract class Post implements Prototype {
    protected String title;
    protected String description;
    protected String budget;
    protected String skills;

    public Post(String title, String description, String budget, String skills) {
        this.title = title;
        this.description = description;
        this.budget = budget;
        this.skills = skills;
    }

    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getBudget() { return budget; }
    public String getSkills() { return skills; }

    public void setTitle(String title) { this.title = title; }
    public void setBudget(String budget) { this.budget = budget; }
}