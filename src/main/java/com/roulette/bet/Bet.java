package com.roulette.bet;

import com.roulette.core.Field;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class Bet {
    private static final long NO_WIN = 0L;

    private final long bet;

    public long pay(Field field) {
        return winCondition(field) ? bet * multiplier() : NO_WIN;
    }

    protected abstract boolean winCondition(Field field);

    protected abstract int multiplier();
}
