package com.roulette.core.bet.strategy.nowin;

import com.roulette.core.bet.Bet;
import com.roulette.util.Boolean;

public class DoubleBetColorStrategy extends NoWinBetStrategy<Boolean> {

    protected Bet<Boolean> colorBet;

    public DoubleBetColorStrategy(Bet<Boolean> bet) {
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
