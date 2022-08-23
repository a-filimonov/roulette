package com.roulette.strategy;

import java.util.function.Function;

import com.roulette.bet.Bet;
import com.roulette.bet.outisde.ColorBet;

public class DoubleBetColorStrategy implements Function<Long, Bet> {

    protected ColorBet bet;

    public DoubleBetColorStrategy(ColorBet bet) {
        this.bet = bet;
    }

    @Override
    public ColorBet apply(Long win) {
        this.bet = this.bet.doubled();
        return this.bet;
    }
}
