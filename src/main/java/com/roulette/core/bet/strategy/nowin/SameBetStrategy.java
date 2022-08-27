package com.roulette.core.bet.strategy.nowin;

import com.roulette.core.bet.Bet;
import com.roulette.core.bet.Factor;

public class SameBetStrategy<F extends Factor> extends NoWinBetStrategy<F> {

    private final Bet<F> userBet;

    public SameBetStrategy(Bet<F> bet) {
        super(bet.getBet());
        this.userBet = bet;
    }

    @Override
    public String getName() {
        return "All bets on " + userBet;
    }

    @Override
    public Bet<F> apply() {
        return userBet;
    }
}
