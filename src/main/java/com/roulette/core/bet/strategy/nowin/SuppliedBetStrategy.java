package com.roulette.core.bet.strategy.nowin;

import com.roulette.core.bet.Bet;
import com.roulette.core.bet.Factor;

public class SuppliedBetStrategy<F extends Factor> extends NoWinBetStrategy<F> {
    private final BetSupplier<F> betSupplier;

    public SuppliedBetStrategy(BetSupplier<F> betSupplier) {
        super(0L);
        this.betSupplier = betSupplier;
    }

    @Override
    public String getName() {
        return betSupplier.getName();
    }

    @Override
    public Bet<F> apply() {
        return betSupplier.get();
    }
}
