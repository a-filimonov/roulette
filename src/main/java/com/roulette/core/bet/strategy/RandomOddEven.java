package com.roulette.core.bet.strategy;

import com.roulette.core.bet.Bet;
import com.roulette.core.bet.outisde.EvenBet;
import com.roulette.util.BooleanUtil;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RandomOddEven implements BetStrategy {

    private final long bet;

    @Override
    public String getName() {
        return "Random Odd/Even";
    }

    @Override
    public Bet apply(Long win) {
        return new EvenBet(bet, BooleanUtil.flipCoin());
    }
}
