package com.roulette.core.bet.inside;

import com.roulette.core.bet.Bet;
import com.roulette.core.field.Field;
import com.roulette.core.field.Split;

public class SplitBet extends Bet<Split> {

    public SplitBet(long bet, Split split) {
        super(bet, split);
    }

    @Override
    protected boolean winCondition(Field field) {
        return field.equals(factor.getF1()) || field.equals(factor.getF2());
    }

    @Override
    protected int multiplier() {
        return 18;
    }

    @Override
    public String toString() {
        return String.format("Split %s:%s", factor.getF1().getNumber(), factor.getF2().getNumber());
    }
}
