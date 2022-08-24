package com.roulette.strategy;

import com.roulette.bet.Bet;
import com.roulette.bet.inside.SplitBet;
import com.roulette.core.SplitRegistry;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RandomSplit implements BetStrategy {

    private final long bet;

    @Override
    public String getName() {
        return "Random Split";
    }

    @Override
    public Bet apply(Long win) {
        return new SplitBet(bet, SplitRegistry.random());
    }
}
