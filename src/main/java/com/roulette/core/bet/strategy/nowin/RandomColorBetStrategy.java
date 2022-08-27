package com.roulette.core.bet.strategy.nowin;

import com.roulette.core.bet.Bet;
import com.roulette.core.bet.outisde.ColorBet;
import com.roulette.util.Boolean;

public class RandomColorBetStrategy extends NoWinBetStrategy<Boolean> {

    public RandomColorBetStrategy(long bet) {
        super(bet);
    }

    @Override
    public String getName() {
        return "Random Color";
    }

    @Override
    public Bet<Boolean> apply() {
        return ColorBet.random(bet);
    }
}
