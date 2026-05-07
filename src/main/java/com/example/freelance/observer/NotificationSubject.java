package com.example.freelance.observer;

public interface NotificationSubject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers();
}