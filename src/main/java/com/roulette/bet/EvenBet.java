package com.roulette.bet;

import lombok.Getter;

@Getter
public class EvenBet extends Bet {

    private final boolean even;

    public EvenBet(long bet, boolean even) {
        super(bet);
        this.even = even;
    }

    @Override
    public String toString() {
        return even ? "EVEN" : "ODD";
    }
}
