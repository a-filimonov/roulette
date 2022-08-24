package com.roulette.core.bet.outisde;

import com.roulette.core.bet.Bet;
import com.roulette.core.field.Field;
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
                return "Column 1-34";
            case C2:
                return "Column 2-35";
            default:
                return "Column 3-36";
        }
    }
}
