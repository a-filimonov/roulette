package com.roulette.core.bet.strategy.nowin;

import com.roulette.core.bet.Bet;
import com.roulette.core.bet.inside.StreetBet;
import com.roulette.core.field.Street;
import com.roulette.core.field.StreetRegistry;

public class RandomStreet extends NoWinBetStrategy<Street> {

    public RandomStreet(long bet) {
        super(bet);
    }

    @Override
    public String getName() {
        return "Random Street";
    }

    @Override
    public Bet<Street> apply() {
        return new StreetBet(bet, StreetRegistry.random());
    }
}
