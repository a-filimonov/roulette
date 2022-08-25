package com.roulette.core.bet.strategy.win;

import com.roulette.core.bet.Bet;
import com.roulette.core.bet.outisde.bool.BooleanBet;
import com.roulette.core.bet.strategy.BetStrategy;

/**
 * User adds 1, 2, 3, 5, 8, 13... numbers to the bet if he wins
 * User returns to initial bet when he loses
 */
public class FibonacciStrategy implements BetStrategy {

    private final BooleanBet initialBet;
    private int lastFib;
    private int currentFib;
    private BooleanBet currentBet;

    public FibonacciStrategy(BooleanBet bet) {
        this.initialBet = bet; // save
        this.lastFib = 1;
        this.currentFib = 0;
        this.currentBet = bet;
    }

    @Override
    public Bet apply(Long win) {
        if (win > 0) {
            int increase = this.lastFib + this.currentFib;
            this.currentBet = this.currentBet.add(increase);
            this.lastFib = this.currentFib;
            this.currentFib = increase;
        } else {
            this.currentBet = this.initialBet;
            this.lastFib = 1;
            this.currentFib = 0;
        }
        return this.currentBet;
    }

    @Override
    public String getName() {
        return "Fibonacci strategy";
    }

    @Override
    public String toString() {
        return getName();
    }
}
