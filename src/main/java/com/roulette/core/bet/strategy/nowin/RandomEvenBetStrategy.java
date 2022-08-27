package com.roulette.core.bet.strategy.nowin;

import com.roulette.core.bet.Bet;
import com.roulette.core.bet.outisde.EvenBet;
import com.roulette.util.Boolean;

public class RandomEvenBetStrategy extends NoWinBetStrategy<Boolean> {

    public RandomEvenBetStrategy(long bet) {
        super(bet);
    }

    @Override
    public String getName() {
        return "Random Odd/Even";
    }

    @Override
    public Bet<Boolean> apply() {
        return EvenBet.random(bet);
    }
}
