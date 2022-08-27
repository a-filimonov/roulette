package com.roulette.core.bet.strategy.nowin;

import com.roulette.core.bet.Bet;
import com.roulette.core.bet.outisde.DozenBet;
import com.roulette.core.field.Field;

public class RandomDozenBetStrategy extends NoWinBetStrategy<Field.Dozen> {

    public RandomDozenBetStrategy(long bet) {
        super(bet);
    }

    @Override
    public String getName() {
        return "Random Dozen";
    }

    @Override
    public Bet<Field.Dozen> apply() {
        return DozenBet.random(bet);
    }
}
