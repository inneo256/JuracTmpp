package com.example.freelance.observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotificationStorage {

    private static final Map<String, List<String>> notifications = new HashMap<>();

    public static void addNotification(String username, String message) {
        System.out.println("💾 Добавлено уведомление для " + username);
        notifications.computeIfAbsent(username, k -> new ArrayList<>()).add(message);
    }

    public static List<String> getNotifications(String username) {
        return notifications.getOrDefault(username, new ArrayList<>());
    }





}
