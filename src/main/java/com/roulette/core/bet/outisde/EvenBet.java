package com.roulette.core.bet.outisde;

import com.roulette.core.bet.Bet;
import com.roulette.core.field.Field;
import com.roulette.util.Boolean;
import lombok.Getter;

@Getter
public class EvenBet extends Bet<Boolean> {

    public EvenBet(long bet, Boolean even) {
        super(bet, even);
    }

    @Override
    protected boolean winCondition(Field field) {
        if (field.isZero()) {
            return false;
        }
        return (field.isEven() && factor.isTrue()) || (!field.isEven() && factor.isFalse());
    }

    @Override
    protected int multiplier() {
        return 2;
    }

    @Override
    public String toString() {
        return factor.isTrue() ? "EVEN" : "ODD";
    }

    public Bet<Boolean> add(long amount) {
        return new EvenBet(bet + amount, factor);
    }

    public Bet<Boolean> doubled() {
        return new EvenBet(bet * 2, factor);
    }
}
