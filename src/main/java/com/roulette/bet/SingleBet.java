package com.roulette.bet;

import com.roulette.Field;
import lombok.Getter;

@Getter
public class SingleBet extends Bet {

    private final Field field;
    private long bet;

    public SingleBet(Field field, long bet) {
        super(bet);
        this.field = field;
    }
}
