package com.roulette.core.bet.strategy.nowin;

import com.roulette.core.bet.Bet;
import com.roulette.core.bet.inside.LineBet;
import com.roulette.core.field.Line;
import com.roulette.core.field.LineRegistry;

public class RandomLine extends NoWinBetStrategy<Line> {

    public RandomLine(long bet) {
        super(bet);
    }

    @Override
    public String getName() {
        return "Random Line";
    }

    @Override
    public Bet<Line> apply() {
        return new LineBet(bet, LineRegistry.random());
    }
}
