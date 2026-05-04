package com.example.freelance.adapter;

public class StripeService {
    public String sendPayment(double value) {
        try {
            Thread.sleep(500); // имитация задержки
        } catch (InterruptedException e) {}

        return "Stripe: платеж обработан с задержкой. Сумма: " + value;
    }
}