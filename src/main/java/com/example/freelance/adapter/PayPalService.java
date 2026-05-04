package com.example.freelance.adapter;

public class PayPalService {
    public String makePayment(double sum) {
        double fee = sum * 0.05;
        double total = sum + fee;

        return "PayPal: сумма " + sum + " + комиссия 5% = " + total;
    }
}