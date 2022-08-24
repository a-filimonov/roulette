package com.roulette.core.bet.strategy;

import com.roulette.core.bet.Bet;
import com.roulette.core.bet.outisde.HalfBet;
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
