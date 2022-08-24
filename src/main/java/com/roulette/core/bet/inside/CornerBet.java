package com.roulette.core.bet.inside;

import com.roulette.core.bet.Bet;
import com.roulette.core.field.Corner;
import com.roulette.core.field.Field;

public class CornerBet extends Bet {

    private final Corner corner;

    public CornerBet(long bet, Corner corner) {
        super(bet);
        this.corner = corner;
    }

    @Override
    protected boolean winCondition(Field field) {
        return field.equals(corner.getF1()) || field.equals(corner.getF2()) ||
            field.equals(corner.getF3()) || field.equals(corner.getF4());
    }

    @Override
    protected int multiplier() {
        return 8;
    }

    @Override
    public String toString() {
        return String.format("Corner %s:%s:%s:%s", corner.getF1().getNumber(), corner.getF2().getNumber(), corner.getF3().getNumber(), corner.getF4().getNumber());
    }
}
