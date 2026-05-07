package com.example.freelance.observer;

public class FreelancerObserver implements Observer {

    private final String freelancerName;
    private final OrderNotificationSubject subject;
    private String observerState;

    public FreelancerObserver(String freelancerName, OrderNotificationSubject subject) {
        this.freelancerName = freelancerName;
        this.subject = subject;
    }

    @Override
    public void update() {
        observerState = "🔔 " + freelancerName + ", новый заказ: " + subject.getState();
        NotificationStorage.addNotification(freelancerName, observerState);
    }
}

