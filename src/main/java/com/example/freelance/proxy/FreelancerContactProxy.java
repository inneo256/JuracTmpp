package com.example.freelance.proxy;

import com.example.freelance.model.UserEntity;

public class FreelancerContactProxy implements FreelancerContactAccess {

    private final UserEntity freelancer;
    private final boolean approved;
    private RealFreelancerContactAccess realSubject;

    public FreelancerContactProxy(UserEntity freelancer, boolean approved) {
        this.freelancer = freelancer;
        this.approved = approved;
    }

    @Override
    public String request() {
        if (!approved) {
            return "Контакты скрыты. Сначала отправьте запрос и дождитесь ответа.";
        }

        if (realSubject == null) {
            realSubject = new RealFreelancerContactAccess(freelancer);
        }

        return realSubject.request();
    }
}