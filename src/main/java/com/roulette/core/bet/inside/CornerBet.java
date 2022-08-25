package com.roulette.core.bet.inside;

import com.roulette.core.bet.Bet;
import com.roulette.core.field.Corner;
import com.roulette.core.field.Field;

public class CornerBet extends Bet<Corner> {

    public CornerBet(long bet, Corner corner) {
        super(bet, corner);
    }

    @Override
    protected boolean winCondition(Field field) {
        return field.equals(factor.getF1()) || field.equals(factor.getF2()) ||
            field.equals(factor.getF3()) || field.equals(factor.getF4());
    }

    @Override
    protected int multiplier() {
        return 8;
    }

    @Override
    public String toString() {
        return String.format("Corner %s-%s", factor.getF1().getNumber(), factor.getF4().getNumber());
    }
}
