package com.roulette.core.bet.strategy.nowin;

import com.roulette.core.bet.Bet;
import com.roulette.util.Boolean;

public class DoubleBetStrategy extends NoWinBetStrategy<Boolean> {

    protected Bet<Boolean> userBet;

    public DoubleBetStrategy(Bet<Boolean> bet) {
        super(bet.getBet());
        this.userBet = bet;
    }

    @Override
    public String getName() {
        return "Double bet";
    }

    @Override
    public Bet<Boolean> apply() {
        this.userBet = this.userBet.doubled();
        return this.userBet;
    }
}
