package com.example.freelance.adapter;

public class CardService {
    public String processCard(double amount) {
        if (amount > 500) {
            return "Карта: превышен лимит!";
        }

        return "Карта: оплата успешна. Сумма: " + amount;
    }
}