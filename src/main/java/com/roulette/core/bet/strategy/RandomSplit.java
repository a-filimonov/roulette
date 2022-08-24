package com.roulette.core.bet.strategy;

import com.roulette.core.bet.Bet;
import com.roulette.core.bet.inside.SplitBet;
import com.roulette.core.field.SplitRegistry;
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
