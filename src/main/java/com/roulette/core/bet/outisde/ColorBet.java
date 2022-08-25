package com.roulette.core.bet.outisde;

import com.roulette.core.field.Field;
import com.roulette.core.bet.Bet;
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

    public ColorBet doubledAnd(long extraBet) {
        return new ColorBet(getBet() * 2 + extraBet, color);
    }

    @Override
    protected boolean winCondition(Field field) {
        return field.getColor().equals(color);
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
