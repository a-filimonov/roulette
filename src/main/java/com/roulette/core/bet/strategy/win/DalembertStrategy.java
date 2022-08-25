package com.roulette.core.bet.strategy.win;

import com.roulette.core.bet.Bet;
import com.roulette.core.bet.outisde.bool.BooleanBet;
import com.roulette.core.bet.strategy.BetStrategy;

/**
 * User adds 1 to the bet stake every time he loses
 * User removes 1 from the bet stake every time he wins
 */
public class DalembertStrategy implements BetStrategy<Boolean> {

    private BooleanBet currentBet;

    public DalembertStrategy(BooleanBet bet) {
        this.currentBet = bet;
    }

    @Override
    public Bet<Boolean> apply(Long win) {
        this.currentBet = win == 0 ? this.currentBet.add(1) : this.currentBet.add(-1);
        return this.currentBet;
    }

    @Override
    public String getName() {
        return "D'Alembert strategy";
    }

    @Override
    public String toString() {
        return getName();
    }
}
