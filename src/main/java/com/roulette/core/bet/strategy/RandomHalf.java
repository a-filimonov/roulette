package com.roulette.core.bet.strategy;

import com.roulette.core.bet.Bet;
import com.roulette.core.bet.outisde.HalfBet;
import com.roulette.util.BooleanUtil;

public class RandomHalf extends NoWinBetStrategy {

    public RandomHalf(long bet) {
        super(bet);
    }

    @Override
    public String getName() {
        return "Random Half";
    }

    @Override
    public Bet apply() {
        return new HalfBet(bet, BooleanUtil.flipCoin());
    }
}
