package com.roulette.core.bet.strategy.nowin;

import com.roulette.core.bet.Bet;
import com.roulette.core.bet.outisde.ColumnBet;
import com.roulette.core.field.Field;

public class RandomColumn extends NoWinBetStrategy<Field.Column> {

    public RandomColumn(long bet) {
        super(bet);
    }

    @Override
    public String getName() {
        return "Random Column";
    }

    @Override
    public Bet<Field.Column> apply() {
        return new ColumnBet(bet, Field.Column.random());
    }
}
