package com.roulette.core.bet.inside;

import com.roulette.core.field.Field;
import com.roulette.core.bet.Bet;
import lombok.Getter;

@Getter
public class FieldBet extends Bet<Field> {

    public FieldBet(long bet, Field field) {
        super(bet, field);
    }

    @Override
    protected boolean winCondition(Field field) {
        return field.equals(this.factor);
    }

    @Override
    protected int multiplier() {
        return 36;
    }

    @Override
    public String toString() {
        return factor.toString();
    }
}
