package com.roulette.core.bet.strategy.nowin;

import com.roulette.core.bet.Bet;
import com.roulette.core.bet.inside.FieldBet;
import com.roulette.core.field.Field;
import com.roulette.core.field.FieldRegistry;

public class RandomField extends NoWinBetStrategy<Field> {

    public RandomField(long bet) {
        super(bet);
    }

    @Override
    public String getName() {
        return "Random Field";
    }

    @Override
    public Bet apply() {
        return new FieldBet(bet, FieldRegistry.random());
    }
}
