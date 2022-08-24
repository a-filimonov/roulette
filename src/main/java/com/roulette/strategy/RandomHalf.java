package com.roulette.strategy;

import com.roulette.bet.Bet;
import com.roulette.bet.outisde.HalfBet;
import com.roulette.util.BooleanUtil;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RandomHalf implements BetStrategy {

    private final long bet;

    @Override
    public String getName() {
        return "Random Half";
    }

    @Override
    public Bet apply(Long win) {
        return new HalfBet(bet, BooleanUtil.flipCoin());
    }
}
