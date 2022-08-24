package com.roulette.core.bet.strategy;

import com.roulette.core.bet.Bet;
import com.roulette.core.bet.inside.SplitBet;
import com.roulette.core.bet.inside.StreetBet;
import com.roulette.core.field.SplitRegistry;
import com.roulette.core.field.StreetRegistry;

public class RandomStreet extends NoWinBetStrategy {

    public RandomStreet(long bet) {
        super(bet);
    }

    @Override
    public String getName() {
        return "Random Street";
    }

    @Override
    public Bet apply() {
        return new StreetBet(bet, StreetRegistry.random());
    }
}
