package com.roulette.core.bet.strategy;

import com.roulette.core.bet.Bet;
import com.roulette.core.bet.inside.SingleBet;
import com.roulette.core.field.FieldRegistry;
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
