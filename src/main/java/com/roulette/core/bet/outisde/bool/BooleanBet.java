package com.roulette.core.bet.outisde.bool;

import com.roulette.core.bet.Bet;

public abstract class BooleanBet extends Bet<Boolean> {

    public BooleanBet(long bet, boolean factor) {
        super(bet, factor);
    }

    @Override
    protected int multiplier() {
        return 2;
    }

    public abstract BooleanBet add(long amount);

    public abstract BooleanBet doubled();

}
