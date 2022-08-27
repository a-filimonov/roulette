package com.roulette.core.bet.inside;

import com.roulette.core.bet.Bet;
import com.roulette.core.field.Field;
import com.roulette.core.field.Split;
import com.roulette.core.field.SplitRegistry;

public class SplitBet extends Bet<Split> {

    public SplitBet(long bet, Split split) {
        super(bet, split);
    }

    public static Bet<Split> random(long bet) {
        return new SplitBet(bet, SplitRegistry.random());
    }

    @Override
    protected boolean winCondition(Field field) {
        return field.equals(factor.getF1()) || field.equals(factor.getF2());
    }

    @Override
    protected int multiplier() {
        return 18;
    }

    public Bet<Split> add(long amount) {
        return new SplitBet(bet + amount, factor);
    }

    public Bet<Split> doubled() {
        return new SplitBet(bet * 2, factor);
    }

    @Override
    public String toString() {
        return String.format("Split %s:%s", factor.getF1().getNumber(), factor.getF2().getNumber());
    }
}
