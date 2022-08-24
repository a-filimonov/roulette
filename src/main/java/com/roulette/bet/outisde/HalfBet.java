package com.roulette.bet.outisde;

import com.roulette.bet.Bet;
import com.roulette.core.Field;
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
        return this.firstHalf && field.isFirstHalf() || !this.firstHalf && !field.isFirstHalf();
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
