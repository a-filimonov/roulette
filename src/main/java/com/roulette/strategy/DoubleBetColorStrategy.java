package com.roulette.strategy;

import com.roulette.bet.Bet;
import com.roulette.bet.outisde.ColorBet;

public class DoubleBetColorStrategy implements BetStrategy {

    protected ColorBet bet;

    public DoubleBetColorStrategy(ColorBet bet) {
        this.bet = bet;
    }

    @Override
    public String getName() {
        return "[NEEDS A FIX] Doubles the bet every turn";
    }

    @Override
    public Bet apply(Long win) {
        this.bet = this.bet.doubled();
        return this.bet;
    }
}
