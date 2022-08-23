package com.roulette.bet.inside;

import com.roulette.core.Field;
import com.roulette.bet.Bet;
import lombok.Getter;

@Getter
public class SingleBet extends Bet {

    private final Field field;

    public SingleBet(long bet, Field field) {
        super(bet);
        this.field = field;
    }

    @Override
    public String toString() {
        return field.toString();
    }
}
