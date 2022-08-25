package com.roulette.core.bet.strategy.nowin;

import com.roulette.core.bet.Bet;
import com.roulette.core.bet.strategy.BetStrategy;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class NoWinBetStrategy implements BetStrategy {

    protected final long bet;

    @Override
    public Bet apply(Long win) {
        return apply();
    }

    public abstract Bet apply();

    @Override
    public String toString() {
        return getName();
    }
}
