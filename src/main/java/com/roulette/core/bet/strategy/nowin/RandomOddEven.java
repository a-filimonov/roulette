package com.roulette.core.bet.strategy.nowin;

import com.roulette.core.bet.Bet;
import com.roulette.core.bet.outisde.EvenBet;
import com.roulette.util.BooleanUtil;

public class RandomOddEven extends NoWinBetStrategy {

    public RandomOddEven(long bet) {
        super(bet);
    }

    @Override
    public String getName() {
        return "Random Odd/Even";
    }

    @Override
    public Bet apply() {
        return new EvenBet(bet, BooleanUtil.flipCoin());
    }
}