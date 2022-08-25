package com.roulette.core.bet.strategy.win;

import com.roulette.core.bet.Bet;
import com.roulette.core.bet.outisde.bool.BooleanBet;
import com.roulette.core.bet.strategy.BetStrategy;

/**
 * User doubles the bet and adds initial bet amount every time he loses
 * Returns to initial bet when won
 */
public class GrandMartingaleStrategy implements BetStrategy {

    private final BooleanBet initialBet;
    private BooleanBet currentBet;

    public GrandMartingaleStrategy(BooleanBet bet) {
        this.initialBet = bet; // save
        this.currentBet = bet;
    }

    @Override
    public Bet apply(Long win) {
        this.currentBet = win == 0 ? this.currentBet.doubled().add(this.initialBet.getBet()) : this.initialBet;
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
