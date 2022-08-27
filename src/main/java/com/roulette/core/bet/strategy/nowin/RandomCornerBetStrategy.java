package com.roulette.core.bet.strategy.nowin;

import com.roulette.core.bet.Bet;
import com.roulette.core.bet.inside.CornerBet;
import com.roulette.core.field.Corner;

public class RandomCornerBetStrategy extends NoWinBetStrategy<Corner> {

    public RandomCornerBetStrategy(long bet) {
        super(bet);
    }

    @Override
    public String getName() {
        return "Random Corner";
    }

    @Override
    public Bet<Corner> apply() {
        return CornerBet.random(bet);
    }
}
