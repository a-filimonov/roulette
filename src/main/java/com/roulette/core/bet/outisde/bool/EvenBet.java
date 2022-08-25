package com.roulette.core.bet.outisde.bool;

import com.roulette.core.field.Field;
import lombok.Getter;

@Getter
public class EvenBet extends BooleanBet {

    public EvenBet(long bet, boolean even) {
        super(bet, even);
    }

    @Override
    protected boolean winCondition(Field field) {
        if (field.isZero()) {
            return false;
        }
        return (field.isEven() && factor) || (!field.isEven() && !factor);
    }

    @Override
    public String toString() {
        return factor ? "EVEN" : "ODD";
    }

    public BooleanBet add(long amount) {
        return new EvenBet(bet + amount, factor);
    }

    public BooleanBet doubled() {
        return new EvenBet(bet * 2, factor);
    }
}
