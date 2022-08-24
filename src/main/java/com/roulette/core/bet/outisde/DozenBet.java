package com.roulette.core.bet.outisde;

import com.roulette.core.bet.Bet;
import com.roulette.core.field.Field;
import lombok.Getter;

@Getter
public class DozenBet extends Bet {

    private final Field.Dozen dozen;

    public DozenBet(long bet, Field.Dozen dozen) {
        super(bet);
        this.dozen = dozen;
    }

    @Override
    protected boolean winCondition(Field field) {
        if (field.isZero()) {
            return false;
        }
        return field.getDozen() == dozen;
    }

    @Override
    protected int multiplier() {
        return 3;
    }

    @Override
    public String toString() {
        switch (dozen) {
            case D1:
                return "1-12";
            case D2:
                return "13-24";
            default:
                return "25-36";
        }
    }
}
