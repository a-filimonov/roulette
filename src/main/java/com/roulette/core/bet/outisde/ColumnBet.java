package com.roulette.core.bet.outisde;

import com.roulette.core.bet.Bet;
import com.roulette.core.field.Field;
import lombok.Getter;

@Getter
public class ColumnBet extends Bet<Field.Column> {

    public ColumnBet(long bet, Field.Column column) {
        super(bet, column);
    }

    public static Bet<Field.Column> random(long bet) {
        return new ColumnBet(bet, Field.Column.random());
    }

    @Override
    protected boolean winCondition(Field field) {
        if (field.isZero()) {
            return false;
        }
        return field.getColumn() == factor;
    }

    @Override
    protected int multiplier() {
        return 3;
    }

    public Bet<Field.Column> add(long amount) {
        return new ColumnBet(bet + amount, factor);
    }

    public Bet<Field.Column> doubled() {
        return new ColumnBet(bet * 2, factor);
    }

    @Override
    public String toString() {
        switch (factor) {
            case C1:
                return "Column 1-34";
            case C2:
                return "Column 2-35";
            default:
                return "Column 3-36";
        }
    }
}
