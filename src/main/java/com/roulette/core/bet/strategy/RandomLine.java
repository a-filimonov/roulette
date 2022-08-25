package com.roulette.core.bet.strategy;

import com.roulette.core.bet.Bet;
import com.roulette.core.bet.inside.LineBet;
import com.roulette.core.field.LineRegistry;

public class RandomLine extends NoWinBetStrategy {

    public RandomLine(long bet) {
        super(bet);
    }

    @Override
    public String getName() {
        return "Random Line";
    }

    @Override
    public Bet apply() {
        return new LineBet(bet, LineRegistry.random());
    }
}
