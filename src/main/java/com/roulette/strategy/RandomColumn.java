package com.roulette.strategy;

import com.roulette.bet.Bet;
import com.roulette.bet.outisde.ColumnBet;
import com.roulette.core.Field;
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
