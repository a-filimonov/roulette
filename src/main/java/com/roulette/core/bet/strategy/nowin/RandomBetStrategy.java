package com.roulette.core.bet.strategy.nowin;

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
import com.roulette.core.bet.Factor;
import lombok.AllArgsConstructor;

public class RandomBetStrategy extends NoWinBetStrategy<Factor> {

    private final RandomBetRegistry registry;

    public RandomBetStrategy(long bet) {
        super(bet);
        registry = new RandomBetRegistry(bet);
    }

    @Override
    public String getName() {
        return "Random bet";
    }

    @Override
    public Bet apply() {
        return registry.get();
    }

    @AllArgsConstructor
    public static class RandomBetRegistry {

        private static final Random RANDOM = new Random();

        protected final long bet;

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
}
