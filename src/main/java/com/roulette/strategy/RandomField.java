package com.roulette.strategy;

import com.roulette.bet.Bet;
import com.roulette.bet.inside.SingleBet;
import com.roulette.bet.inside.SplitBet;
import com.roulette.core.FieldRegistry;
import com.roulette.core.SplitRegistry;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RandomField implements BetStrategy {

    private final long bet;

    @Override
    public String getName() {
        return "Random Field";
    }

    @Override
    public Bet apply(Long win) {
        return new SingleBet(bet, FieldRegistry.random());
    }
}
