package com.roulette.core.bet.strategy;

import com.roulette.core.bet.Bet;
import com.roulette.core.bet.outisde.ColorBet;
import com.roulette.core.field.Field;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RandomColor implements BetStrategy {

    private final long bet;

    @Override
    public String getName() {
        return "Random Color";
    }

    @Override
    public Bet apply(Long win) {
        return new ColorBet(bet, Field.Color.random());
    }
}
