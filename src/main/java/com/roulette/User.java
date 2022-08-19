package com.roulette;

import lombok.Getter;

@Getter
public class User {
    private final String name;
    private long balance;
    private long maxBalance;

    public User(String name, long balance) {
        this.name = name;
        this.balance = balance;
        this.maxBalance = balance;
    }

    public boolean isAbleToBet(long betAmount) {
        return balance >= betAmount;
    }

    public void bet(long betAmount) {
        balance -= betAmount;
    }

    public void win(long winAmount) {
        balance += winAmount;
        if (balance > maxBalance) {
            maxBalance = balance;
        }
    }

    @Override
    public String toString() {
        return String.format("%s (%s)", name, balance);
    }

}
