package com.roulette.core.bet.strategy.win;

import com.roulette.core.bet.Bet;
import com.roulette.core.bet.strategy.BetStrategy;
import com.roulette.util.Boolean;

/**
 * User adds 1 to the bet stake every time he loses
 * User removes 1 from the bet stake every time he wins
 */
public class DalembertStrategy implements BetStrategy<Boolean> {

    private Bet<Boolean> userBet;

    public DalembertStrategy(Bet<Boolean> bet) {
        this.userBet = bet;
    }

    @Override
    public Bet<Boolean> apply(Long win) {
        this.userBet = win == 0 ? this.userBet.add(1) : this.userBet.add(-1);
        return this.userBet;
    }

    @Override
    public String getName() {
        return "D'Alembert";
    }

    @Override
    public String toString() {
        return getName();
    }
}
