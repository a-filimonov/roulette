package com.roulette.core.bet.strategy;

import com.roulette.core.bet.Bet;
import com.roulette.core.bet.outisde.ColumnBet;
import com.roulette.core.field.Field;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RandomColumn implements BetStrategy {

    private final long bet;

    @Override
    public String getName() {
        return "Random Column";
    }

    @Override
    public Bet apply(Long win) {
        return new ColumnBet(bet, Field.Column.random());
    }
}
