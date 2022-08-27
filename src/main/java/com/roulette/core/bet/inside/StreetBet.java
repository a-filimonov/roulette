package com.roulette.core.bet.inside;

import com.roulette.core.bet.Bet;
import com.roulette.core.field.Field;
import com.roulette.core.field.Street;
import com.roulette.core.field.StreetRegistry;

public class StreetBet extends Bet<Street> {

    public StreetBet(long bet, Street street) {
        super(bet, street);
    }

    public static Bet<Street> random(long bet) {
        return new StreetBet(bet, StreetRegistry.random());
    }

    @Override
    protected boolean winCondition(Field field) {
        return field.equals(factor.getF1()) ||
            field.equals(factor.getF2()) ||
            field.equals(factor.getF3());
    }

    @Override
    protected int multiplier() {
        return 11;
    }

    public Bet<Street> add(long amount) {
        return new StreetBet(bet + amount, factor);
    }

    public Bet<Street> doubled() {
        return new StreetBet(bet * 2, factor);
    }

    @Override
    public String toString() {
        return String.format("Street %s-%s", factor.getF1().getNumber(), factor.getF3().getNumber());
    }
}
