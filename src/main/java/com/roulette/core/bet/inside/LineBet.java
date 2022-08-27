package com.roulette.core.bet.inside;

import com.roulette.core.bet.Bet;
import com.roulette.core.field.Field;
import com.roulette.core.field.Line;
import com.roulette.core.field.LineRegistry;

public class LineBet extends Bet<Line> {

    public LineBet(long bet, Line line) {
        super(bet, line);
    }

    public static Bet<Line> random(long bet) {
        return new LineBet(bet, LineRegistry.random());
    }

    @Override
    protected boolean winCondition(Field field) {
        return field.equals(factor.getF1()) || field.equals(factor.getF2()) ||
            field.equals(factor.getF3()) || field.equals(factor.getF4()) ||
            field.equals(factor.getF5()) || field.equals(factor.getF6());
    }

    @Override
    protected int multiplier() {
        return 5;
    }

    public Bet<Line> add(long amount) {
        return new LineBet(bet + amount, factor);
    }

    public Bet<Line> doubled() {
        return new LineBet(bet * 2, factor);
    }

    @Override
    public String toString() {
        return String.format("Line %s-%s", factor.getF1().getNumber(), factor.getF6().getNumber());
    }
}
