package com.example.freelance.Registry;

public class SiteStats {

    private static SiteStats instance;

    private int freelancerCount = 0;
    private int clientCount = 0;
    private int orderCount = 0;
    private int cloneCount = 0;

    private SiteStats() {}

    public static SiteStats getInstance() {
        if (instance == null) {
            instance = new SiteStats();
        }
        return instance;
    }

    public void addFreelancer() { freelancerCount++; }
    public void addClient() { clientCount++; }
    public void addOrder() { orderCount++; }
    public void addClone() { cloneCount++; }

    public int getFreelancerCount() { return freelancerCount; }
    public int getClientCount() { return clientCount; }
    public int getOrderCount() { return orderCount; }
    public int getCloneCount() { return cloneCount; }
    public int getTotalUsers() { return freelancerCount + clientCount; }
}