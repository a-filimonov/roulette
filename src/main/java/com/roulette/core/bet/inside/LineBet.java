package com.roulette.core.bet.inside;

import com.roulette.core.bet.Bet;
import com.roulette.core.field.Field;
import com.roulette.core.field.Line;

public class LineBet extends Bet {

    private final Line line;

    public LineBet(long bet, Line line) {
        super(bet);
        this.line = line;
    }

    @Override
    protected boolean winCondition(Field field) {
        return field.equals(line.getF1()) || field.equals(line.getF2()) ||
            field.equals(line.getF3()) || field.equals(line.getF4()) ||
            field.equals(line.getF5()) || field.equals(line.getF6());
    }

    @Override
    protected int multiplier() {
        return 5;
    }

    @Override
    public String toString() {
        return String.format("Line %s-%s", line.getF1().getNumber(), line.getF6().getNumber());
    }
}
