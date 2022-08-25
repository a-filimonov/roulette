package com.roulette.core.bet.outisde.bool;

import com.roulette.core.bet.Bet;

public abstract class BooleanBet extends Bet {

    protected final boolean state;

    public BooleanBet(long bet, boolean state) {
        super(bet);
        this.state = state;
    }

    @Override
    protected int multiplier() {
        return 2;
    }

    public abstract BooleanBet add(long amount);

    public abstract BooleanBet doubled();

}
