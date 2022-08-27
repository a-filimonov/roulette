package com.roulette.core.bet;

import java.util.List;
import java.util.Random;

import com.roulette.core.bet.inside.CornerBet;
import com.roulette.core.bet.inside.FieldBet;
import com.roulette.core.bet.inside.LineBet;
import com.roulette.core.bet.inside.SplitBet;
import com.roulette.core.bet.inside.StreetBet;
import com.roulette.core.bet.outisde.ColorBet;
import com.roulette.core.bet.outisde.ColumnBet;
import com.roulette.core.bet.outisde.DozenBet;
import com.roulette.core.bet.outisde.EvenBet;
import com.roulette.core.bet.outisde.HalfBet;
import com.roulette.core.field.CornerRegistry;
import com.roulette.core.field.Field;
import com.roulette.core.field.FieldRegistry;
import com.roulette.core.field.LineRegistry;
import com.roulette.core.field.SplitRegistry;
import com.roulette.core.field.StreetRegistry;
import com.roulette.util.Boolean;

public class BetRegistry {

    private static final Random RANDOM = new Random();

    private final long bet;

    public BetRegistry(long bet) {
        this.bet = bet;
    }

    public Bet<?> random() {
        List<Bet<?>> randomBets = listBets(bet);
        return randomBets.get(RANDOM.nextInt(randomBets.size()));
    }

    private static List<Bet<?>> listBets(long bet) {
        return List.of(
            new CornerBet(bet, CornerRegistry.random()),
            new FieldBet(bet, FieldRegistry.random()),
            new LineBet(bet, LineRegistry.random()),
            new SplitBet(bet, SplitRegistry.random()),
            new StreetBet(bet, StreetRegistry.random()),
            new ColumnBet(bet, Field.Column.random()),
            new DozenBet(bet, Field.Dozen.random()),
            new ColorBet(bet, Boolean.random()),
            new EvenBet(bet, Boolean.random()),
            new HalfBet(bet, Boolean.random())
        );
    }
}
