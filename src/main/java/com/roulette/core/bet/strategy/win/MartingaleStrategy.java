package com.roulette.core.bet.strategy.win;

import com.roulette.core.bet.Bet;
import com.roulette.core.bet.outisde.bool.BooleanBet;
import com.roulette.core.bet.strategy.BetStrategy;

/**
 * User doubles the bet every time he loses
 * Returns to initial bet when won
 */
public class MartingaleStrategy implements BetStrategy<Boolean> {

    private final BooleanBet initialBet;
    private BooleanBet currentBet;

    public MartingaleStrategy(BooleanBet bet) {
        this.initialBet = bet; // save
        this.currentBet = bet;
    }

    @Override
    public Bet<Boolean> apply(Long win) {
        this.currentBet = win == 0 ? this.currentBet.doubled() : this.initialBet;
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
