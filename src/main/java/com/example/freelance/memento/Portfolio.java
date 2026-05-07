package com.example.freelance.memento;

public class Portfolio {

    private String description;
    private String skills;
    private String works;
    private String certificates;

    public Portfolio(String description, String skills, String works, String certificates) {
        this.description = description;
        this.skills = skills;
        this.works = works;
        this.certificates = certificates;
    }

    public PortfolioMemento createMemento() {
        return new PortfolioMemento(description, skills, works, certificates);
    }

    public void setMemento(PortfolioMemento memento) {
        this.description = memento.getDescription();
        this.skills = memento.getSkills();
        this.works = memento.getWorks();
        this.certificates = memento.getCertificates();
    }

    public void update(String description, String skills, String works, String certificates) {
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