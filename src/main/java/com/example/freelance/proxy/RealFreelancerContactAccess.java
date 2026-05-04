package com.example.freelance.proxy;

import com.example.freelance.model.UserEntity;

public class RealFreelancerContactAccess implements FreelancerContactAccess {

    private final UserEntity freelancer;

    public RealFreelancerContactAccess(UserEntity freelancer) {
        this.freelancer = freelancer;
    }

    @Override
    public String request() {
        String email = freelancer.getEmail();
        String telegram = freelancer.getTelegram();

        if (email == null || email.isBlank()) {
            email = "не указан";
        }

        if (telegram == null || telegram.isBlank()) {
            telegram = "не указан";
        }

        return "Email: " + email + " | Telegram: " + telegram;
    }
}