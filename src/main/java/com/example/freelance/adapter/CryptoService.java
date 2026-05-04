package com.example.freelance.adapter;

public class CryptoService {
    public String payWithCrypto(double amount) {
        double rate = 0.00002; // типа BTC курс
        double cryptoAmount = amount * rate;

        return "Crypto: списано " + cryptoAmount + " BTC (эквивалент " + amount + "$)";
    }
}