package com.roulette.strategy;

import com.roulette.bet.Bet;
import com.roulette.bet.outisde.EvenBet;
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
