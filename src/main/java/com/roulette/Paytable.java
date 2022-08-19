package com.roulette;

import com.roulette.bet.ColorBet;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Paytable {

    private final Field field;

    public long process(ColorBet bet) {
        return bet.getColor().equals(field.getColor()) ? bet.getBet() * 2 : 0L;
    }
}
