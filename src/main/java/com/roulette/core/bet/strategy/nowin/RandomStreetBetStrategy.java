package com.roulette.core.bet.strategy.nowin;

import com.roulette.core.bet.Bet;
import com.roulette.core.bet.inside.StreetBet;
import com.roulette.core.field.Street;

public class RandomStreetBetStrategy extends NoWinBetStrategy<Street> {

    public RandomStreetBetStrategy(long bet) {
        super(bet);
    }

    @Override
    public String getName() {
        return "Random Street";
    }

    @Override
    public Bet<Street> apply() {
        return StreetBet.random(bet);
    }
}
