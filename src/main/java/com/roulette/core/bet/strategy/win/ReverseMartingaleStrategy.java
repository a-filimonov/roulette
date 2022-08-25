package com.roulette.core.bet.strategy.win;

import com.roulette.core.bet.Bet;
import com.roulette.core.bet.outisde.ColorBet;
import com.roulette.core.bet.strategy.BetStrategy;

/**
 * User doubles the bet every time he wins
 * Returns to initial bet when lost
 */
public class ReverseMartingaleStrategy implements BetStrategy {

    private final ColorBet initialBet;
    private ColorBet currentBet;

    public ReverseMartingaleStrategy(ColorBet bet) {
        this.initialBet = bet; // save
        this.currentBet = bet;
    }

    @Override
    public Bet apply(Long win) {
        this.currentBet = win > 0 ? this.currentBet.doubled() : this.initialBet;
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
