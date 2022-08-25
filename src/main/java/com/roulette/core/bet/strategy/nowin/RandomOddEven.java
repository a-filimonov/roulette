package com.roulette.core.bet.strategy.nowin;

import com.roulette.core.bet.Bet;
import com.roulette.core.bet.outisde.EvenBet;
import com.roulette.util.Boolean;

public class RandomOddEven extends NoWinBetStrategy<Boolean> {

    public RandomOddEven(long bet) {
        super(bet);
    }

    @Override
    public String getName() {
        return "Random Odd/Even";
    }

    @Override
    public Bet<Boolean> apply() {
        return new EvenBet(bet, Boolean.random());
    }
}
