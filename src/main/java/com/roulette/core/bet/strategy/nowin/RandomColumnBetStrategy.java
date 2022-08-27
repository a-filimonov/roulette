package com.roulette.core.bet.strategy.nowin;

import com.roulette.core.bet.Bet;
import com.roulette.core.bet.outisde.ColumnBet;
import com.roulette.core.field.Field;

public class RandomColumnBetStrategy extends NoWinBetStrategy<Field.Column> {

    public RandomColumnBetStrategy(long bet) {
        super(bet);
    }

    @Override
    public String getName() {
        return "Random Column";
    }

    @Override
    public Bet<Field.Column> apply() {
        return ColumnBet.random(bet);
    }
}
