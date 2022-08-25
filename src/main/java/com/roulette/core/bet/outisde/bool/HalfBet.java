package com.roulette.core.bet.outisde.bool;

import com.roulette.core.field.Field;
import lombok.Getter;

@Getter
public class HalfBet extends BooleanBet {

    public HalfBet(long bet, boolean firstHalf) {
        super(bet, firstHalf);
    }

    @Override
    protected boolean winCondition(Field field) {
        if (field.isZero()) {
            return false;
        }
        return (field.isFirstHalf() && factor) || (!field.isFirstHalf() && !factor);
    }

    @Override
    public String toString() {
        return factor ? "1-18" : "19-36";
    }

    public BooleanBet add(long amount) {
        return new HalfBet(bet + amount, factor);
    }

    public BooleanBet doubled() {
        return new HalfBet(bet * 2, factor);
    }
}
