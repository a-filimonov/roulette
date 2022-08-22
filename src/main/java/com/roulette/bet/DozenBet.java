package com.roulette.bet;

import lombok.Getter;

@Getter
public class DozenBet extends Bet {

    private final Dozen dozen;

    public DozenBet(long bet, Dozen dozen) {
        super(bet);
        this.dozen = dozen;
    }

    public enum Dozen {
        FIRST, SECOND, THIRD
    }

    @Override
    public String toString() {
        switch (dozen) {
            case FIRST:
                return "1-12";
            case SECOND:
                return "13-24";
            default:
                return "25-36";
        }
    }
}
