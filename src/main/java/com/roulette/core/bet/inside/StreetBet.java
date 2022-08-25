package com.roulette.core.bet.inside;

import com.roulette.core.bet.Bet;
import com.roulette.core.field.Field;
import com.roulette.core.field.Street;

public class StreetBet extends Bet {

    private final Street street;

    public StreetBet(long bet, Street street) {
        super(bet);
        this.street = street;
    }

    @Override
    protected boolean winCondition(Field field) {
        return field.equals(street.getF1()) ||
            field.equals(street.getF2()) ||
            field.equals(street.getF3());
    }

    @Override
    protected int multiplier() {
        return 11;
    }

    @Override
    public String toString() {
        return String.format("Street %s-%s", street.getF1().getNumber(), street.getF3().getNumber());
    }
}
