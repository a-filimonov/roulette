package com.roulette.core.bet.strategy.win;

import com.roulette.core.bet.Bet;
import com.roulette.core.bet.strategy.BetStrategy;
import com.roulette.util.Boolean;

/**
 * User doubles the bet every time he wins
 * Returns to initial bet when lost
 */
public class ReverseMartingaleStrategy implements BetStrategy<Boolean> {

    private final Bet<Boolean> initialBet;
    private Bet<Boolean> currentBet;

    public ReverseMartingaleStrategy(Bet<Boolean> bet) {
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
        return "Reverse Martingale";
    }

    @Override
    public String toString() {
        return getName();
    }
}
