package com.roulette.core.bet;

import com.roulette.core.field.Field;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class Bet<F extends Factor> {
    private static final long NO_WIN = 0L;

    protected final long bet;

    protected final F factor;

    public long pay(Field field) {
        return winCondition(field) ? bet * multiplier() : NO_WIN;
    }

    protected abstract boolean winCondition(Field field);

    protected abstract int multiplier();

    public abstract Bet<F> add(long amount);

    public abstract Bet<F> doubled();
}
