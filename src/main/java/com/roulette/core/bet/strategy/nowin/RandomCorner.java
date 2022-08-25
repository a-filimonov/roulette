package com.roulette.core.bet.strategy.nowin;

import com.roulette.core.bet.Bet;
import com.roulette.core.bet.inside.CornerBet;
import com.roulette.core.field.Corner;
import com.roulette.core.field.CornerRegistry;

public class RandomCorner extends NoWinBetStrategy<Corner> {

    public RandomCorner(long bet) {
        super(bet);
    }

    @Override
    public String getName() {
        return "Random Corner";
    }

    @Override
    public Bet<Corner> apply() {
        return new CornerBet(bet, CornerRegistry.random());
    }
}
