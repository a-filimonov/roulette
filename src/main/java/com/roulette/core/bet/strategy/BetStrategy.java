package com.roulette.core.bet.strategy;

import java.util.function.Function;

import com.roulette.core.bet.Bet;

/**
 * Bet function that calculates next bet based on previous turn win amount
 */
public interface BetStrategy<T> extends Function<Long, Bet<T>> {
    String getName();
}
