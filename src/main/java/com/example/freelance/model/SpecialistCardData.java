package com.example.freelance.model;

public class SpecialistCardData {

    private String username;
    private String skillType;
    private boolean approved;
    private String contactInfo;

    public SpecialistCardData(String username, String skillType, boolean approved, String contactInfo) {
        this.username = username;
        this.skillType = skillType;
        this.approved = approved;
        this.contactInfo = contactInfo;
    }

    public String getUsername() {
        return username;
    }

    public String getSkillType() {
        return skillType;
    }

    public boolean isApproved() {
        return approved;
    }

    public String getContactInfo() {
        return contactInfo;
    }
}