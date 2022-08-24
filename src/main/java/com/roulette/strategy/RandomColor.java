package com.roulette.strategy;

import com.roulette.bet.Bet;
import com.roulette.bet.outisde.ColorBet;
import com.roulette.core.Field;
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
