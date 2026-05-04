package com.example.freelance.adapter;

public class CardAdapter implements Payment {

    private final CardService cardService;

    public CardAdapter(CardService cardService) {
        this.cardService = cardService;
    }

    @Override
    public String pay(double amount) {
        return cardService.processCard(amount);
    }
}