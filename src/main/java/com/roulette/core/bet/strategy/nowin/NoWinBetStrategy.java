package com.roulette.core.bet.strategy.nowin;

import com.roulette.core.bet.Bet;
import com.roulette.core.bet.Factor;
import com.roulette.core.bet.strategy.BetStrategy;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class NoWinBetStrategy<F extends Factor> implements BetStrategy<F> {

    protected final long bet;

    @Override
    public Bet<F> apply(Long win) {
        return apply();
    }

    public abstract Bet<F> apply();

    @Override
    public String toString() {
        return getName();
    }
}
