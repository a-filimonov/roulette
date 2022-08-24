package com.roulette.bet.outisde;

import com.roulette.core.Field;
import com.roulette.bet.Bet;
import lombok.Getter;

@Getter
public class ColorBet extends Bet {

    private final Field.Color color;

    public ColorBet(long bet, Field.Color color) {
        super(bet);
        this.color = color;
    }

    public ColorBet doubled() {
        return new ColorBet(getBet() * 2, color);
    }

    @Override
    protected boolean winCondition(Field field) {
        return this.color.equals(field.getColor());
    }

    @Override
    protected int multiplier() {
        return 2;
    }

    @Override
    public String toString() {
        return color.name();
    }
}
