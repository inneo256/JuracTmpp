package com.example.freelance.memento;

import java.util.Stack;

public class PortfolioHistory {

    private final Stack<PortfolioMemento> history = new Stack<>();

    public void save(Portfolio portfolio) {
        history.push(portfolio.createMemento());
    }

    public PortfolioMemento getLastMemento() {
        if (history.isEmpty()) {
            return null;
        }
        return history.pop();
    }

    public boolean hasHistory() {
        return !history.isEmpty();
    }
}