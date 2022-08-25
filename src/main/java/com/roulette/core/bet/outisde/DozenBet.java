package com.roulette.core.bet.outisde;

import com.roulette.core.bet.Bet;
import com.roulette.core.field.Field;
import lombok.Getter;

@Getter
public class DozenBet extends Bet<Field.Dozen> {

    public DozenBet(long bet, Field.Dozen dozen) {
        super(bet, dozen);
    }

    @Override
    protected boolean winCondition(Field field) {
        if (field.isZero()) {
            return false;
        }
        return field.getDozen() == factor;
    }

    @Override
    protected int multiplier() {
        return 3;
    }

    @Override
    public String toString() {
        switch (factor) {
            case D1:
                return "1-12";
            case D2:
                return "13-24";
            default:
                return "25-36";
        }
    }
}
