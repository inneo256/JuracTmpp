package com.example.freelance.adapter;

public class CryptoAdapter implements Payment {

    private final CryptoService cryptoService;

    public CryptoAdapter(CryptoService cryptoService) {
        this.cryptoService = cryptoService;
    }

    @Override
    public String pay(double amount) {
        return cryptoService.payWithCrypto(amount);
    }
}