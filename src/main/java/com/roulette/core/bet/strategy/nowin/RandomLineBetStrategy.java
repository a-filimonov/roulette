package com.roulette.core.bet.strategy.nowin;

import com.roulette.core.bet.Bet;
import com.roulette.core.bet.inside.LineBet;
import com.roulette.core.field.Line;

public class RandomLineBetStrategy extends NoWinBetStrategy<Line> {

    public RandomLineBetStrategy(long bet) {
        super(bet);
    }

    @Override
    public String getName() {
        return "Random Line";
    }

    @Override
    public Bet<Line> apply() {
        return LineBet.random(bet);
    }
}
