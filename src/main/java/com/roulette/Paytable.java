package com.roulette;

import com.roulette.bet.Bet;
import com.roulette.bet.inside.SingleBet;
import com.roulette.bet.outisde.ColorBet;
import com.roulette.bet.outisde.ColumnBet;
import com.roulette.bet.outisde.DozenBet;
import com.roulette.bet.outisde.EvenBet;
import com.roulette.bet.outisde.HalfBet;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Paytable {

    private static final long NO_WIN = 0L;

    private final Field field;

    //TODO refactor bets
    public long process(Bet bet) {
        // outside
        if (bet instanceof ColorBet) {
            return process((ColorBet) bet);
        }
        if (bet instanceof EvenBet) {
            return process((EvenBet) bet);
        }
        if (bet instanceof HalfBet) {
            return process((HalfBet) bet);
        }
        if (bet instanceof DozenBet) {
            return process((DozenBet) bet);
        }
        if (bet instanceof ColumnBet) {
            return process((ColumnBet) bet);
        }

        // inside
        if (bet instanceof SingleBet) {
            return process((SingleBet) bet);
        }

        throw new RuntimeException("Unsupported bet: " + bet);
    }

    private long process(ColorBet bet) {
        if (field.isZero()) {
            return NO_WIN; // for now ZERO pays 0
        }
        return bet.getColor().equals(field.getColor()) ?
            payOneToOne(bet) :
            NO_WIN;
    }

    private long process(EvenBet bet) {
        if (field.isZero()) {
            return NO_WIN; // for now ZERO pays 0
        }
        return (bet.isEven() && field.isEven()) || (!bet.isEven() && !field.isEven()) ?
            payOneToOne(bet) :
            NO_WIN;
    }

    private long process(HalfBet bet) {
        if (field.isZero()) {
            return NO_WIN; // for now ZERO pays 0
        }
        return (bet.isFirstHalf() && field.isFirstHalf()) || (!bet.isFirstHalf() && !field.isFirstHalf()) ?
            payOneToOne(bet) :
            NO_WIN;
    }

    private long process(DozenBet bet) {
        if (field.isZero()) {
            return NO_WIN; // for now ZERO pays 0
        }
        return field.isDozen(bet.getDozen()) ? payTwoToOne(bet) : NO_WIN;
    }

    private long process(ColumnBet bet) {
        if (field.isZero()) {
            return NO_WIN; // for now ZERO pays 0
        }
        return field.isInColumn(bet.getColumn()) ? payTwoToOne(bet) : NO_WIN;
    }

    private long process(SingleBet bet) {
        return field.equals(bet.getField()) ? bet.getBet() * 37 : NO_WIN;
    }

    private static long payOneToOne(Bet bet) {
        return bet.getBet() * 2;
    }

    private long payTwoToOne(Bet bet) {
        return bet.getBet() * 3;
    }
}
