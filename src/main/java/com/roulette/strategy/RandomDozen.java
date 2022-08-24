package com.roulette.strategy;

import com.roulette.bet.Bet;
import com.roulette.bet.outisde.DozenBet;
import com.roulette.core.Field;
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
