package com.roulette.core.bet.strategy.nowin;

import com.roulette.core.bet.Bet;
import com.roulette.core.bet.BetRegistry;
import com.roulette.core.bet.Factor;

public class RandomBetStrategy extends NoWinBetStrategy<Factor> {

    private final BetRegistry registry;

    public RandomBetStrategy(long bet) {
        super(bet);
        registry = new BetRegistry(bet);
    }

    @Override
    public String getName() {
        return "Random bet";
    }

    @Override
    public Bet apply() {
        return registry.random();
    }
}
