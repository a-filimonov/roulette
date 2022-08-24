package com.roulette.bet.outisde;

import com.roulette.bet.Bet;
import com.roulette.core.Field;
import lombok.Getter;

@Getter
public class DozenBet extends Bet {

    private final Dozen dozen;

    public DozenBet(long bet, Dozen dozen) {
        super(bet);
        this.dozen = dozen;
    }

    public enum Dozen {
        FIRST, SECOND, THIRD;
    }

    @Override
    protected boolean winCondition(Field field) {
        if (field.isZero()) {
            return false;
        }
        return field.isDozen(dozen);
    }

    @Override
    protected int multiplier() {
        return 3;
    }

    @Override
    public String toString() {
        switch (dozen) {
            case FIRST:
                return "1-12";
            case SECOND:
                return "13-24";
            default:
                return "25-36";
        }
    }
}
