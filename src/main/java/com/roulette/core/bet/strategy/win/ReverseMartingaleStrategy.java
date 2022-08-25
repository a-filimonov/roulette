package com.roulette.core.bet.strategy.win;

import com.roulette.core.bet.Bet;
import com.roulette.core.bet.outisde.ColorBet;
import com.roulette.core.bet.strategy.nowin.DoubleBetColorStrategy;

/**
 * User doubles the bet every time he wins
 * Returns to initial bet when lost
 */
public class ReverseMartingaleStrategy extends DoubleBetColorStrategy {

    private ColorBet currentBet;

    public ReverseMartingaleStrategy(ColorBet bet) {
        super(bet); // save initial bet
        this.currentBet = bet;
    }

    @Override
    public Bet apply(Long win) {
        this.currentBet = win > 0 ? this.currentBet.doubled() : this.colorBet;
        return this.currentBet;
    }

    @Override
    public String getName() {
        return "Reverse Martingale strategy";
    }

    @Override
    public String toString() {
        return getName();
    }
}
