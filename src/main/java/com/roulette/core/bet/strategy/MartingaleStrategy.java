package com.roulette.core.bet.strategy;

import com.roulette.core.bet.Bet;
import com.roulette.core.bet.outisde.ColorBet;

/**
 * User doubles the bet every time he loses
 * Returns to initial bet when won
 */
public class MartingaleStrategy extends DoubleBetColorStrategy {

    private ColorBet currentBet;

    public MartingaleStrategy(ColorBet bet) {
        super(bet); // save initial bet
        this.currentBet = bet;
    }

    @Override
    public Bet apply(Long win) {
        this.currentBet = win == 0 ? this.currentBet.doubled() : this.colorBet;
        return this.currentBet;
    }

    @Override
    public String getName() {
        return "Martingale strategy";
    }

    @Override
    public String toString() {
        return getName();
    }
}
