package com.roulette.core.user;

import com.roulette.core.bet.strategy.BetStrategy;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@EqualsAndHashCode(of = "name")
public class User {
    private final String name;
    private final BetStrategy<?> strategy;
    private long balance;
    @Setter
    private long lastWin;

    public User(String name, BetStrategy<?> strategy, long balance) {
        this.name = name;
        this.strategy = strategy;
        this.balance = balance;
    }

    public boolean hasMoney() {
        return balance > 0;
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
