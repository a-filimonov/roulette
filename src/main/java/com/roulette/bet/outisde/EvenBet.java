package com.roulette.bet.outisde;

import com.roulette.bet.Bet;
import com.roulette.core.Field;
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
        return (this.even && field.isEven()) || (!this.even && !field.isEven());
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
