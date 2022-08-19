package com.roulette.bet;

import com.roulette.Field;
import lombok.Getter;

@Getter
public class SplitBet extends Bet {
    Field leftField;
    Field rightField;

    public SplitBet(long bet, Field leftField, Field rightField) {
        super(bet);
        this.leftField = leftField;
        this.rightField = rightField;
    }
}
