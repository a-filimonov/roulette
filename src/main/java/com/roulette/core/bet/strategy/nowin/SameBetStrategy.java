package com.roulette.core.bet.strategy.nowin;

import com.roulette.core.bet.Bet;
import com.roulette.core.bet.Factor;

public class SameBetStrategy<F extends Factor> extends NoWinBetStrategy<F> {

    private final Bet<F> currentBet;

    public SameBetStrategy(Bet<F> bet) {
        super(bet.getBet());
        this.currentBet = bet;
    }

    @Override
    public String getName() {
        return "All bets on " + currentBet;
    }

    @Override
    public Bet<F> apply() {
        return currentBet;
    }
}
