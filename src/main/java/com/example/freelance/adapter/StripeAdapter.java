package com.example.freelance.adapter;

public class StripeAdapter implements Payment {

    private final StripeService stripeService;

    public StripeAdapter(StripeService stripeService) {
        this.stripeService = stripeService;
    }

    @Override
    public String pay(double amount) {
        return stripeService.sendPayment(amount);
    }
}