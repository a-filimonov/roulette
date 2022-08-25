package com.roulette.core.bet.strategy.win;

import com.roulette.core.bet.Bet;
import com.roulette.core.bet.outisde.ColorBet;
import com.roulette.core.bet.strategy.nowin.DoubleBetColorStrategy;

/**
 * User doubles the bet and adds initial bet amount every time he loses
 * Returns to initial bet when won
 */
public class GrandMartingaleStrategy extends DoubleBetColorStrategy {

    private ColorBet currentBet;

    public GrandMartingaleStrategy(ColorBet bet) {
        super(bet); // save initial bet
        this.currentBet = bet;
    }

    @Override
    public Bet apply(Long win) {
        this.currentBet = win == 0 ? this.currentBet.doubledAnd(this.colorBet.getBet()) : this.colorBet;
        return this.currentBet;
    }

    @Override
    public String getName() {
        return "Grand Martingale strategy";
    }

    @Override
    public String toString() {
        return getName();
    }
}
