package com.roulette.strategy;

import com.roulette.bet.ColorBet;

public class MartingaleStrategy extends DoubleBetColorStrategy {

    private ColorBet currentBet;

    public MartingaleStrategy(ColorBet bet) {
        super(bet); // save initial bet
        this.currentBet = bet;
    }

    @Override
    public ColorBet apply(Long win) {
        this.currentBet = win == 0 ? this.currentBet.doubled() : this.bet;
        return this.currentBet;
    }
}
