package com.roulette.core.bet.strategy;

import com.roulette.core.bet.Bet;
import com.roulette.core.bet.outisde.DozenBet;
import com.roulette.core.field.Field;

public class RandomDozen extends NoWinBetStrategy {

    public RandomDozen(long bet) {
        super(bet);
    }

    @Override
    public String getName() {
        return "Random Dozen";
    }

    @Override
    public Bet apply() {
        return new DozenBet(bet, Field.Dozen.random());
    }
}
