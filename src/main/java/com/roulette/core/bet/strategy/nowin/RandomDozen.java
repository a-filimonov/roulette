package com.roulette.core.bet.strategy.nowin;

import com.roulette.core.bet.Bet;
import com.roulette.core.bet.outisde.DozenBet;
import com.roulette.core.field.Field;

public class RandomDozen extends NoWinBetStrategy<Field.Dozen> {

    public RandomDozen(long bet) {
        super(bet);
    }

    @Override
    public String getName() {
        return "Random Dozen";
    }

    @Override
    public Bet<Field.Dozen> apply() {
        return new DozenBet(bet, Field.Dozen.random());
    }
}
