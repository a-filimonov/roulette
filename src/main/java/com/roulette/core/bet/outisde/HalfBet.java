package com.roulette.core.bet.outisde;

import com.roulette.core.bet.Bet;
import com.roulette.core.field.Field;
import lombok.Getter;

@Getter
public class HalfBet extends Bet {

    private final boolean firstHalf;

    public HalfBet(long bet, boolean firstHalf) {
        super(bet);
        this.firstHalf = firstHalf;
    }

    @Override
    protected boolean winCondition(Field field) {
        if (field.isZero()) {
            return false;
        }
        return (field.isFirstHalf() && firstHalf) || (!field.isFirstHalf() && !firstHalf);
    }

    @Override
    protected int multiplier() {
        return 2;
    }

    @Override
    public String toString() {
        return firstHalf ? "1-18" : "19-36";
    }
}
