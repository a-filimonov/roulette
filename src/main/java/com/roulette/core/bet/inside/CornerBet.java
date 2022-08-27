package com.roulette.core.bet.inside;

import com.roulette.core.bet.Bet;
import com.roulette.core.field.Corner;
import com.roulette.core.field.CornerRegistry;
import com.roulette.core.field.Field;

public class CornerBet extends Bet<Corner> {

    public CornerBet(long bet, Corner corner) {
        super(bet, corner);
    }

    public static Bet<Corner> random(long bet) {
        return new CornerBet(bet, CornerRegistry.random());
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

    public Bet<Corner> add(long amount) {
        return new CornerBet(bet + amount, factor);
    }

    public Bet<Corner> doubled() {
        return new CornerBet(bet * 2, factor);
    }

    @Override
    public String toString() {
        return String.format("Corner %s-%s", factor.getF1().getNumber(), factor.getF4().getNumber());
    }
}
