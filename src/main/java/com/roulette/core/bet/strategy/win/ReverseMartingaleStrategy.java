package com.roulette.core.bet.strategy.win;

import com.roulette.core.bet.Bet;
import com.roulette.core.bet.outisde.bool.BooleanBet;
import com.roulette.core.bet.strategy.BetStrategy;

/**
 * User doubles the bet every time he wins
 * Returns to initial bet when lost
 */
public class ReverseMartingaleStrategy implements BetStrategy<Boolean> {

    private final BooleanBet initialBet;
    private BooleanBet currentBet;

    public ReverseMartingaleStrategy(BooleanBet bet) {
        this.initialBet = bet; // save
        this.currentBet = bet;
    }

    @Override
    public Bet<Boolean> apply(Long win) {
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
