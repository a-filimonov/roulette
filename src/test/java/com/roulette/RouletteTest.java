package com.roulette;

import java.util.stream.Stream;

import com.roulette.core.bet.Bet;
import com.roulette.core.bet.inside.SingleBet;
import com.roulette.core.bet.inside.SplitBet;
import com.roulette.core.bet.outisde.ColorBet;
import com.roulette.core.bet.outisde.ColumnBet;
import com.roulette.core.bet.outisde.DozenBet;
import com.roulette.core.bet.outisde.EvenBet;
import com.roulette.core.bet.outisde.HalfBet;
import com.roulette.core.field.Field;
import com.roulette.core.field.Field.Color;
import com.roulette.core.field.Split;
import com.roulette.core.user.User;
import com.roulette.exception.EndGameException;
import com.roulette.log.Log;
import com.roulette.stats.Stats;
import com.roulette.core.bet.strategy.BetStrategy;
import com.roulette.core.bet.strategy.DoubleBetColorStrategy;
import com.roulette.core.bet.strategy.MartingaleStrategy;
import com.roulette.core.bet.strategy.RandomColor;
import com.roulette.core.bet.strategy.RandomColumn;
import com.roulette.core.bet.strategy.RandomDozen;
import com.roulette.core.bet.strategy.RandomField;
import com.roulette.core.bet.strategy.RandomHalf;
import com.roulette.core.bet.strategy.RandomOddEven;
import com.roulette.core.bet.strategy.RandomSplit;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static com.roulette.core.field.Field.Color.BLACK;
import static com.roulette.core.field.Field.Color.RED;
import static com.roulette.core.field.FieldRegistry.F_17;
import static com.roulette.core.field.FieldRegistry.ZERO;
import static com.roulette.core.field.SplitRegistry.S_1_2;

class RouletteTest {

    private static final long BALANCE = 1000;
    private static final long BET = 15;
    private static final boolean DEBUG = false;
    private static final int ITERATIONS = 10;
    private static final Stats STATS = new Stats();

    @AfterAll
    static void end() {
        STATS.getAll().entrySet().forEach(e -> {
            String name = e.getKey().getName();
            System.out.printf("Roulette [%s]:\n", name);
            e.getValue().forEach(stat -> System.out.printf("\t%s. PAYOUT: %.2f%%\n", stat, stat.payout()));
        });
    }

    @ParameterizedTest
    @MethodSource(value = "betTestCases")
    void shouldPlayRouletteWithGivenBet(Bet bet) {
        for (int i = 0; i < ITERATIONS; i++) {
            play(roulette("All bets on " + bet.toString()), bet);
        }
    }

    @ParameterizedTest
    @MethodSource(value = "betStrategyTestCases")
    void shouldPlayRouletteWithGivenBetStrategy(BetStrategy betStrategy) {
        for (int i = 0; i < ITERATIONS; i++) {
            play(roulette(betStrategy.getName()), betStrategy);
        }
    }

    private static Stream<Arguments> betTestCases() {
        return Stream.of(
            Arguments.of(colorBet(RED)),
            Arguments.of(colorBet(BLACK)),
            Arguments.of(evenBet(true)),
            Arguments.of(evenBet(false)),
            Arguments.of(halfBet(true)),
            Arguments.of(halfBet(false)),
            Arguments.of(dozenBet(Field.Dozen.D1)),
            Arguments.of(dozenBet(Field.Dozen.D2)),
            Arguments.of(dozenBet(Field.Dozen.D3)),
            Arguments.of(columnBet(Field.Column.C1)),
            Arguments.of(columnBet(Field.Column.C2)),
            Arguments.of(columnBet(Field.Column.C3)),
            Arguments.of(singleBet(ZERO)),
            Arguments.of(singleBet(F_17)),
            Arguments.of(splitBet(S_1_2))
        );
    }

    private static Stream<Arguments> betStrategyTestCases() {
        return Stream.of(
            Arguments.of(new MartingaleStrategy(colorBet(RED))),
            Arguments.of(new DoubleBetColorStrategy(colorBet(RED))),    //TODO fix repeats of this strat
            Arguments.of(new RandomColor(BET)),
            Arguments.of(new RandomOddEven(BET)),
            Arguments.of(new RandomHalf(BET)),
            Arguments.of(new RandomDozen(BET)),
            Arguments.of(new RandomColumn(BET)),
            Arguments.of(new RandomSplit(BET)),
            Arguments.of(new RandomField(BET))
        );
    }

    private static void play(Roulette roulette, Bet bet) {
        try {
            while (true) {
                roulette.play(bet);
            }
        } catch (EndGameException e) {
            // stop roulette
        }
    }

    private static void play(Roulette roulette, BetStrategy betStrategy) {
        try {
            Long win = roulette.play(betStrategy.apply(10L));
            while (true) {
                win = roulette.play(betStrategy.apply(win));
            }
        } catch (EndGameException e) {
            // stop roulette
        }
    }

    private static Roulette roulette(String name) {
        User user = new User(name, BALANCE);
        Roulette roulette = new Roulette(user, new Log(DEBUG));
        STATS.register(user, roulette);
        return roulette;
    }

    private static ColorBet colorBet(Color color) {
        return new ColorBet(BET, color);
    }

    private static EvenBet evenBet(boolean even) {
        return new EvenBet(BET, even);
    }

    private static HalfBet halfBet(boolean firstHalf) {
        return new HalfBet(BET, firstHalf);
    }

    private static Bet dozenBet(Field.Dozen dozen) {
        return new DozenBet(BET, dozen);
    }

    private static Bet columnBet(Field.Column column) {
        return new ColumnBet(BET, column);
    }

    private static Bet singleBet(Field field) {
        return new SingleBet(BET, field);
    }

    private static Bet splitBet(Split split) {
        return new SplitBet(BET, split);
    }
}