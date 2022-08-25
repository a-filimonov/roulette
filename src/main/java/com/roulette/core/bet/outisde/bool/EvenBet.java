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
        return (field.isEven() && state) || (!field.isEven() && !state);
    }

    @Override
    public String toString() {
        return state ? "EVEN" : "ODD";
    }

    public BooleanBet add(long amount) {
        return new EvenBet(bet + amount, state);
    }

    public BooleanBet doubled() {
        return new EvenBet(bet * 2, state);
    }
}
