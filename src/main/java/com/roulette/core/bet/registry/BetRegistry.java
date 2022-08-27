package com.roulette.core.bet.registry;

import com.roulette.core.bet.Bet;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class BetRegistry {
    protected final long bet;

    public abstract Bet<?> get();
}
