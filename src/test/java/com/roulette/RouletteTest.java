package com.roulette;

import java.util.function.Function;
import java.util.stream.Stream;

import com.roulette.bet.Bet;
import com.roulette.bet.inside.SingleBet;
import com.roulette.bet.inside.SplitBet;
import com.roulette.bet.outisde.ColorBet;
import com.roulette.bet.outisde.ColumnBet;
import com.roulette.bet.outisde.DozenBet;
import com.roulette.bet.outisde.EvenBet;
import com.roulette.bet.outisde.HalfBet;
import com.roulette.core.Field;
import com.roulette.core.Field.Color;
import com.roulette.core.FieldRegistry;
import com.roulette.core.Split;
import com.roulette.core.SplitRegistry;
import com.roulette.core.User;
import com.roulette.exception.EndGameException;
import com.roulette.log.Log;
import com.roulette.stats.Stats;
import com.roulette.strategy.DoubleBetColorStrategy;
import com.roulette.strategy.MartingaleStrategy;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static com.roulette.core.Field.Color.BLACK;
import static com.roulette.core.Field.Color.RED;
import static com.roulette.core.FieldRegistry.F_17;
import static com.roulette.core.FieldRegistry.ZERO;
import static com.roulette.core.SplitRegistry.S_1_2;
import static com.roulette.util.BooleanUtil.flipCoin;

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

    @RepeatedTest(ITERATIONS)
    void roulette_double_bet_when_lost_martingale_strategy() {
        play(roulette("Martingale strategy"), new MartingaleStrategy(colorBet(RED)));
    }

    @RepeatedTest(ITERATIONS)
    void roulette_always_double_bet() {
        play(roulette("Doubles the bet every turn"), new DoubleBetColorStrategy(colorBet(RED)));
    }

    @RepeatedTest(ITERATIONS)
    void roulette_always_random_color() {
        play(roulette("Random Color"), bet -> colorBet(Color.random()));
    }

    @RepeatedTest(ITERATIONS)
    void roulette_always_random_odd() {
        play(roulette("Random Odd/Even"), bet -> evenBet(flipCoin()));
    }

    @RepeatedTest(ITERATIONS)
    void roulette_always_random_half() {
        play(roulette("Random Half"), bet -> halfBet(flipCoin()));
    }

    @RepeatedTest(ITERATIONS)
    void roulette_always_random_dozen() {
        play(roulette("Random Dozen"), bet -> dozenBet(Field.Dozen.random()));
    }

    @RepeatedTest(ITERATIONS)
    void roulette_always_random_column() {
        play(roulette("Random Column"), bet -> columnBet(Field.Column.random()));
    }

    @RepeatedTest(ITERATIONS)
    void roulette_always_random_split() {
        play(roulette("Random Split"), bet -> splitBet(SplitRegistry.random()));
    }

    @RepeatedTest(ITERATIONS)
    void roulette_always_random_field() {
        play(roulette("Random Field"), bet -> singleBet(FieldRegistry.random()));
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

    private static void play(Roulette roulette, Bet bet) {
        try {
            while (true) {
                roulette.play(bet);
            }
        } catch (EndGameException e) {
            // stop roulette
        }
    }

    private static void play(Roulette roulette, Function<Long, Bet> betFunction) {
        try {
            Long win = roulette.play(betFunction.apply(10L));
            while (true) {
                win = roulette.play(betFunction.apply(win));
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