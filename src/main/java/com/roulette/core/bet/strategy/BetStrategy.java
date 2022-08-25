package com.roulette.core.bet.strategy;

import java.util.function.Function;

import com.roulette.core.bet.Bet;
import com.roulette.core.bet.Factor;

/**
 * Bet function that calculates next bet based on previous turn win amount
 */
public interface BetStrategy<F extends Factor> extends Function<Long, Bet<F>> {
    String getName();
}
