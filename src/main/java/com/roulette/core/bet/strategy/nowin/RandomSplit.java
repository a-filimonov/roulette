package com.roulette.core.bet.strategy.nowin;

import com.roulette.core.bet.Bet;
import com.roulette.core.bet.inside.SplitBet;
import com.roulette.core.field.Split;
import com.roulette.core.field.SplitRegistry;

public class RandomSplit extends NoWinBetStrategy<Split> {

    public RandomSplit(long bet) {
        super(bet);
    }

    @Override
    public String getName() {
        return "Random Split";
    }

    @Override
    public Bet<Split> apply() {
        return new SplitBet(bet, SplitRegistry.random());
    }
}
