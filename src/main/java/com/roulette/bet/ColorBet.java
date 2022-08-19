package com.roulette.bet;

import com.roulette.Field;
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
}
