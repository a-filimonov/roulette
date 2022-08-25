package com.roulette.core.bet;

import com.roulette.core.field.Field;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
//TODO parametrize bet (color, dozen etc)
public abstract class Bet {
    private static final long NO_WIN = 0L;

    protected final long bet;

    public long pay(Field field) {
        return winCondition(field) ? bet * multiplier() : NO_WIN;
    }

    protected abstract boolean winCondition(Field field);

    protected abstract int multiplier();
}
