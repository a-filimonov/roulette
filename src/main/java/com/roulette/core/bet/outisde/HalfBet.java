package com.roulette.core.bet.outisde;

import com.roulette.core.bet.Bet;
import com.roulette.core.field.Field;
import com.roulette.util.Boolean;
import lombok.Getter;

@Getter
public class HalfBet extends Bet<Boolean> {

    public HalfBet(long bet, Boolean firstHalf) {
        super(bet, firstHalf);
    }

    @Override
    protected boolean winCondition(Field field) {
        if (field.isZero()) {
            return false;
        }
        return (field.isFirstHalf() && factor.isTrue()) || (!field.isFirstHalf() && factor.isFalse());
    }

    @Override
    protected int multiplier() {
        return 2;
    }

    @Override
    public String toString() {
        return factor.isTrue() ? "1-18" : "19-36";
    }

    public Bet<Boolean> add(long amount) {
        return new HalfBet(bet + amount, factor);
    }

    public Bet<Boolean> doubled() {
        return new HalfBet(bet * 2, factor);
    }
}
