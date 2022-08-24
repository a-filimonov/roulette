package com.roulette.strategy;

import com.roulette.bet.Bet;
import com.roulette.bet.outisde.ColorBet;

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
        this.currentBet = win == 0 ? this.currentBet.doubled() : this.bet;
        return this.currentBet;
    }

    @Override
    public String getName() {
        return "Martingale strategy";
    }
}
