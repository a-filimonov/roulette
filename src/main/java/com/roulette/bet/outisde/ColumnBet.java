package com.roulette.bet.outisde;

import com.roulette.bet.Bet;
import com.roulette.core.Field;
import lombok.Getter;

@Getter
public class ColumnBet extends Bet {

    private final Column column;

    public ColumnBet(long bet, Column column) {
        super(bet);
        this.column = column;
    }

    public enum Column {
        FIRST, SECOND, THIRD
    }

    @Override
    protected boolean winCondition(Field field) {
        if (field.isZero()) {
            return false;
        }
        return field.isInColumn(column);
    }

    @Override
    protected int multiplier() {
        return 3;
    }

    @Override
    public String toString() {
        switch (column) {
            case FIRST:
                return "1-34";
            case SECOND:
                return "2-35";
            default:
                return "3-36";
        }
    }
}
