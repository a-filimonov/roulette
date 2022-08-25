package com.roulette.core.bet.strategy.nowin;

import com.roulette.core.bet.Bet;
import com.roulette.core.bet.outisde.bool.ColorBet;
import com.roulette.util.BooleanUtil;

public class RandomColor extends NoWinBetStrategy<Boolean> {

    public RandomColor(long bet) {
        super(bet);
    }

    @Override
    public String getName() {
        return "Random Color";
    }

    @Override
    public Bet<Boolean> apply() {
        return new ColorBet(bet, BooleanUtil.flipCoin());
    }
}
