package com.roulette.core.bet.inside;

import com.roulette.core.bet.Bet;
import com.roulette.core.field.Field;
import com.roulette.core.field.Split;

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
        return String.format("Split %s:%s", split.getF1().getNumber(), split.getF2().getNumber());
    }
}
