package com.example.freelance.observer;

import com.example.freelance.UserRepository;
import com.example.freelance.model.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    private final UserRepository userRepository;

    public NotificationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void notifyFreelancersAboutOrder(String title, String skills, String budget) {
        OrderNotificationSubject subject = new OrderNotificationSubject();

        List<UserEntity> freelancers = userRepository.findByRoleIgnoreCase("freelancer");

        for (UserEntity freelancer : freelancers) {
            if (freelancer.getSkillType() != null
                    && skills != null
                    && skills.toLowerCase().contains(freelancer.getSkillType().toLowerCase())) {

                subject.attach(new FreelancerObserver(freelancer.getUsername(), subject));
            }
        }

        subject.setState(title + " | Навыки: " + skills + " | Бюджет: " + budget);

        System.out.println("🔥 Вызван notifyFreelancersAboutOrder");
        System.out.println("TITLE: " + title);
        System.out.println("SKILLS: " + skills);
    }


}