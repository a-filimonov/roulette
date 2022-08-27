package com.roulette.core.bet.registry;

import java.util.List;
import java.util.Random;

import com.roulette.core.bet.Bet;
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

public class RandomBetRegistry extends BetRegistry {

    private static final Random RANDOM = new Random();

    public RandomBetRegistry(long bet) {
        super(bet);
    }

    public Bet<?> get() {
        List<Bet<?>> randomBets = listBets(bet);
        return randomBets.get(RANDOM.nextInt(randomBets.size()));
    }

    private static List<Bet<?>> listBets(long bet) {
        return List.of(
            CornerBet.random(bet),
            FieldBet.random(bet),
            LineBet.random(bet),
            SplitBet.random(bet),
            StreetBet.random(bet),
            ColumnBet.random(bet),
            DozenBet.random(bet),
            ColorBet.random(bet),
            EvenBet.random(bet),
            HalfBet.random(bet)
        );
    }
}
