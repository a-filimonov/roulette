package com.roulette.core.bet.strategy.nowin;

import com.roulette.core.bet.Bet;
import com.roulette.core.bet.inside.SplitBet;
import com.roulette.core.field.Split;

public class RandomSplitBetStrategy extends NoWinBetStrategy<Split> {

    public RandomSplitBetStrategy(long bet) {
        super(bet);
    }

    @Override
    public String getName() {
        return "Random Split";
    }

    @Override
    public Bet<Split> apply() {
        return SplitBet.random(bet);
    }
}
