package com.example.freelance.model;

import jakarta.persistence.*;

@Entity
@Table(name = "contact_requests")
public class ContactRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String clientName;

    @Column(nullable = false)
    private String freelancerName;

    @Column(nullable = false)
    private boolean approved;

    public ContactRequest() {
    }

    public ContactRequest(String clientName, String freelancerName) {
        this.clientName = clientName;
        this.freelancerName = freelancerName;
        this.approved = false; // по умолчанию не принят
    }

    public Long getId() {
        return id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getFreelancerName() {
        return freelancerName;
    }

    public void setFreelancerName(String freelancerName) {
        this.freelancerName = freelancerName;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }
}