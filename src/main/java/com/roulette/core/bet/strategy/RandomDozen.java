package com.roulette.core.bet.strategy;

import com.roulette.core.bet.Bet;
import com.roulette.core.bet.outisde.DozenBet;
import com.roulette.core.field.Field;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RandomDozen implements BetStrategy {

    private final long bet;

    @Override
    public String getName() {
        return "Random Dozen";
    }

    @Override
    public Bet apply(Long win) {
        return new DozenBet(bet, Field.Dozen.random());
    }
}
