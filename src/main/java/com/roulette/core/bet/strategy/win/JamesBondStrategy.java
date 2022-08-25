package com.roulette.core.bet.strategy.win;

import com.roulette.core.bet.Bet;
import com.roulette.core.bet.inside.LineBet;
import com.roulette.core.bet.inside.SingleBet;
import com.roulette.core.bet.outisde.bool.HalfBet;
import com.roulette.core.bet.strategy.nowin.NoWinBetStrategy;

import static com.roulette.core.field.FieldRegistry.ZERO;
import static com.roulette.core.field.LineRegistry.L_13_18;

/**
 * First bet: 140 on 19-36
 * Second bet: 50 on 13-18
 * Third bet: 10 on ZERO
 */
public class JamesBondStrategy extends NoWinBetStrategy {

    private static final Bet FIRST_BET = new HalfBet(140, false);
    private static final Bet SECOND_BET = new LineBet(50, L_13_18);
    private static final Bet THIRD_BET = new SingleBet(10, ZERO);

    private Bet nextBet;

    public JamesBondStrategy() {
        super(FIRST_BET.getBet());
        this.nextBet = FIRST_BET;
    }

    @Override
    public Bet apply() {
        var bet = this.nextBet;
        this.nextBet = switchBet();
        return bet;
    }

    private Bet switchBet() {
        return this.nextBet.equals(FIRST_BET) ? SECOND_BET : this.nextBet.equals(SECOND_BET) ? THIRD_BET : FIRST_BET;
    }

    @Override
    public String getName() {
        return "James Bond strategy";
    }

    @Override
    public String toString() {
        return getName();
    }
}
