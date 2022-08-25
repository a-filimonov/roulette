package com.roulette.core.bet.inside;

import com.roulette.core.bet.Bet;
import com.roulette.core.field.Field;
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

    public Bet<Field> add(long amount) {
        return new FieldBet(bet + amount, factor);
    }

    public Bet<Field> doubled() {
        return new FieldBet(bet * 2, factor);
    }

    @Override
    public String toString() {
        return factor.toString();
    }
}
