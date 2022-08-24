package com.roulette.core.bet.outisde;

import com.roulette.core.bet.Bet;
import com.roulette.core.field.Field;
import lombok.Getter;

@Getter
public class EvenBet extends Bet {

    private final boolean even;

    public EvenBet(long bet, boolean even) {
        super(bet);
        this.even = even;
    }

    @Override
    protected boolean winCondition(Field field) {
        if (field.isZero()) {
            return false;
        }
        return (field.isEven() && even) || (!field.isEven() && !even);
    }

    @Override
    protected int multiplier() {
        return 2;
    }

    @Override
    public String toString() {
        return even ? "EVEN" : "ODD";
    }
}
