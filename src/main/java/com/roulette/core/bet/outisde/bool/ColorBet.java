package com.roulette.core.bet.outisde.bool;

import com.roulette.core.field.Field;
import lombok.Getter;

@Getter
public class ColorBet extends BooleanBet {

    public ColorBet(long bet, boolean isRed) {
        super(bet, isRed);
    }

    @Override
    protected boolean winCondition(Field field) {
        if (field.isZero()) {
            return false;
        }
        return field.getRed() == state;
    }

    @Override
    public String toString() {
        return state ? "RED" : "BLK";
    }

    @Override
    public BooleanBet add(long amount) {
        return new ColorBet(bet + amount, state);
    }

    @Override
    public BooleanBet doubled() {
        return new ColorBet(bet * 2, state);
    }
}
