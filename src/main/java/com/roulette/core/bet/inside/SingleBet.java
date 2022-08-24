package com.roulette.core.bet.inside;

import com.roulette.core.field.Field;
import com.roulette.core.bet.Bet;
import lombok.Getter;

@Getter
public class SingleBet extends Bet {

    private final Field field;

    public SingleBet(long bet, Field field) {
        super(bet);
        this.field = field;
    }

    @Override
    protected boolean winCondition(Field field) {
        return field.equals(this.field);
    }

    @Override
    protected int multiplier() {
        return 36;
    }

    @Override
    public String toString() {
        return field.toString();
    }
}
