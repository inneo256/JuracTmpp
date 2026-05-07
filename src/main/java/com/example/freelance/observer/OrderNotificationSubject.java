package com.example.freelance.observer;

import java.util.ArrayList;
import java.util.List;

public class OrderNotificationSubject implements NotificationSubject {

    private final List<Observer> observers = new ArrayList<>();

    private String subjectState;

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    public void setState(String subjectState) {
        this.subjectState = subjectState;
        notifyObservers();
    }

    public String getState() {
        return subjectState;
    }
}