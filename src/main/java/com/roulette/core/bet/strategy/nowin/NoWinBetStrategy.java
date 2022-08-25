package com.roulette.core.bet.strategy.nowin;

import com.roulette.core.bet.Bet;
import com.roulette.core.bet.strategy.BetStrategy;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class NoWinBetStrategy<T> implements BetStrategy<T> {

    protected final long bet;

    @Override
    public Bet<T> apply(Long win) {
        return apply();
    }

    public abstract Bet<T> apply();

    @Override
    public String toString() {
        return getName();
    }
}
