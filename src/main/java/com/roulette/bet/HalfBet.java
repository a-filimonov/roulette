package com.roulette.bet;

import lombok.Getter;

@Getter
public class HalfBet extends Bet {

    boolean firstHalf;

    public HalfBet(long bet, boolean firstHalf) {
        super(bet);
        this.firstHalf = firstHalf;
    }

    @Override
    public String toString() {
        return firstHalf ? "1-18" : "19-36";
    }
}
