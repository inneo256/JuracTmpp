package com.example.freelance.memento;

public class PortfolioMemento {

    private final String description;
    private final String skills;
    private final String works;
    private final String certificates;

    public PortfolioMemento(String description, String skills, String works, String certificates) {
        this.description = description;
        this.skills = skills;
        this.works = works;
        this.certificates = certificates;
    }

    public String getDescription() {
        return description;
    }

    public String getSkills() {
        return skills;
    }

    public String getWorks() {
        return works;
    }

    public String getCertificates() {
        return certificates;
    }
}