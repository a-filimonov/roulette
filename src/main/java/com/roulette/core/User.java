package com.roulette.core;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(of = "name")
public class User {
    private final String name;
    private long balance;

    public User(String name, long balance) {
        this.name = name;
        this.balance = balance;
    }

    public boolean isAbleToBet(long betAmount) {
        return balance >= betAmount;
    }

    public long bet(long betAmount) {
        balance -= betAmount;
        return balance;
    }

    public long win(long winAmount) {
        balance += winAmount;
        return balance;
    }

    @Override
    public String toString() {
        return String.format("%s (%s)", name, balance);
    }

}
