package com.roulette.bet.outisde;

import com.roulette.bet.Bet;
import com.roulette.core.Field;
import lombok.Getter;

@Getter
public class ColumnBet extends Bet {

    private final Field.Column column;

    public ColumnBet(long bet, Field.Column column) {
        super(bet);
        this.column = column;
    }

    @Override
    protected boolean winCondition(Field field) {
        if (field.isZero()) {
            return false;
        }
        return field.getColumn() == column;
    }

    @Override
    protected int multiplier() {
        return 3;
    }

    @Override
    public String toString() {
        switch (column) {
            case C1:
                return "1-34";
            case C2:
                return "2-35";
            default:
                return "3-36";
        }
    }
}
