package com.roulette.core.bet.strategy;

import com.roulette.core.bet.Bet;
import com.roulette.core.bet.inside.SingleBet;
import com.roulette.core.field.FieldRegistry;

public class RandomField extends NoWinBetStrategy {

    public RandomField(long bet) {
        super(bet);
    }

    @Override
    public String getName() {
        return "Random Field";
    }

    @Override
    public Bet apply() {
        return new SingleBet(bet, FieldRegistry.random());
    }
}
