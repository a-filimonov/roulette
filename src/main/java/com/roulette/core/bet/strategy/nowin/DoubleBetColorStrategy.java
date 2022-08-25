package com.roulette.core.bet.strategy.nowin;

import com.roulette.core.bet.Bet;
import com.roulette.core.bet.outisde.bool.BooleanBet;

public class DoubleBetColorStrategy extends NoWinBetStrategy<Boolean> {

    protected BooleanBet colorBet;

    public DoubleBetColorStrategy(BooleanBet bet) {
        super(bet.getBet());
        this.colorBet = bet;
    }

    @Override
    public String getName() {
        return "Doubles the bet every turn";
    }

    @Override
    public Bet<Boolean> apply() {
        this.colorBet = this.colorBet.doubled();
        return this.colorBet;
    }
}
