package com.roulette.core.bet.strategy.nowin;

import com.roulette.core.bet.Bet;
import com.roulette.core.bet.inside.FieldBet;
import com.roulette.core.field.Field;

public class RandomFieldBetStrategy extends NoWinBetStrategy<Field> {

    public RandomFieldBetStrategy(long bet) {
        super(bet);
    }

    @Override
    public String getName() {
        return "Random Field";
    }

    @Override
    public Bet<Field> apply() {
        return FieldBet.random(bet);
    }
}
