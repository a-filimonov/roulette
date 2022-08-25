package com.roulette.core.bet.strategy.nowin;

import com.roulette.core.bet.Bet;
import com.roulette.core.bet.outisde.ColorBet;

public class DoubleBetColorStrategy extends NoWinBetStrategy {

    protected ColorBet colorBet;

    public DoubleBetColorStrategy(ColorBet colorBet) {
        super(colorBet.getBet());
        this.colorBet = colorBet;
    }

    @Override
    public String getName() {
        return "Doubles the bet every turn";
    }

    @Override
    public Bet apply() {
        this.colorBet = this.colorBet.doubled();
        return this.colorBet;
    }
}
