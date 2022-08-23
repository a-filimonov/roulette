package com.roulette.bet.outisde;

import com.roulette.Field;
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
    public String toString() {
        return color.name();
    }
}
