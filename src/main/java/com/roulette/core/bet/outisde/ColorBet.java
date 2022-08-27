package com.roulette.core.bet.outisde;

import com.roulette.core.bet.Bet;
import com.roulette.core.field.Field;
import com.roulette.util.Boolean;
import lombok.Getter;

@Getter
public class ColorBet extends Bet<Boolean> {

    public ColorBet(long bet, Boolean isRed) {
        super(bet, isRed);
    }

    public static Bet<Boolean> random(long bet) {
        return new ColorBet(bet, Boolean.random());
    }

    @Override
    protected boolean winCondition(Field field) {
        if (field.isZero()) {
            return false;
        }
        return field.getRed() == factor.isTrue();
    }

    @Override
    protected int multiplier() {
        return 2;
    }

    @Override
    public String toString() {
        return factor.isTrue() ? "RED" : "BLK";
    }

    @Override
    public Bet<Boolean> add(long amount) {
        return new ColorBet(bet + amount, factor);
    }

    @Override
    public Bet<Boolean> doubled() {
        return new ColorBet(bet * 2, factor);
    }
}
