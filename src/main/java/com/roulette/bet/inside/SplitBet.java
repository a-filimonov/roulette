package com.roulette.bet.inside;

import com.roulette.bet.Bet;
import com.roulette.core.Field;
import com.roulette.core.Split;

public class SplitBet extends Bet {

    private final Split split;

    public SplitBet(long bet, Split split) {
        super(bet);
        this.split = split;
    }

    @Override
    protected boolean winCondition(Field field) {
        return field.equals(split.getF1()) || field.equals(split.getF2());
    }

    @Override
    protected int multiplier() {
        return 18;
    }

    @Override
    public String toString() {
        return split.getF1().toString() + ":" + split.getF2().toString();
    }
}
