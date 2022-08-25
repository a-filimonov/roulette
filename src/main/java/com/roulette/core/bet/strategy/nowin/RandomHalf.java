package com.roulette.core.bet.strategy.nowin;

import com.roulette.core.bet.Bet;
import com.roulette.core.bet.outisde.HalfBet;
import com.roulette.util.Boolean;

public class RandomHalf extends NoWinBetStrategy<Boolean> {

    public RandomHalf(long bet) {
        super(bet);
    }

    @Override
    public String getName() {
        return "Random Half";
    }

    @Override
    public Bet<Boolean> apply() {
        return new HalfBet(bet, Boolean.random());
    }
}
