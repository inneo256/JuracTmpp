package com.example.freelance.adapter;

public class PayPalAdapter implements Payment {

    private final PayPalService payPalService;

    public PayPalAdapter(PayPalService payPalService) {
        this.payPalService = payPalService;
    }

    @Override
    public String pay(double amount) {
        return payPalService.makePayment(amount);
    }
}