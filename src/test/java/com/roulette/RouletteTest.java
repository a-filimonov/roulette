package com.roulette;

import java.util.function.Function;
import java.util.stream.Stream;

import com.roulette.bet.Bet;
import com.roulette.bet.inside.SingleBet;
import com.roulette.bet.outisde.ColorBet;
import com.roulette.bet.outisde.ColumnBet;
import com.roulette.bet.outisde.DozenBet;
import com.roulette.bet.outisde.EvenBet;
import com.roulette.bet.outisde.HalfBet;
import com.roulette.core.Field;
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
import static com.roulette.core.Field.Color.random;
import static com.roulette.core.FieldRegistry.BLACK_17;
import static com.roulette.core.FieldRegistry.ZERO;

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
    void shouldPlayRouletteWithGivenBet(String strategyName, Bet bet) {
        for (int i = 0; i < ITERATIONS; i++) {
            play(roulette(strategyName), bet);
        }
    }

    @RepeatedTest(ITERATIONS)
    void roulette_double_bet_when_lost_martingale_strategy() {
        play(roulette("User bets by Martingale strategy"), new MartingaleStrategy(colorBet(RED)));
    }

    @RepeatedTest(ITERATIONS)
    void roulette_always_double_bet() {
        play(roulette("User always doubles the bet"), new DoubleBetColorStrategy(colorBet(RED)));
    }

    private static Stream<Arguments> betTestCases() {
        return Stream.of(
            Arguments.of("User bets always RED color", colorBet(RED)),
            Arguments.of("User bets always BLACK color", colorBet(BLACK)),
            Arguments.of("User bets random color", colorBet(random())),
            Arguments.of("User bets always EVEN", evenBet(true)),
            Arguments.of("User bets always ODD", evenBet(false)),
            Arguments.of("User bets 1-18", halfBet(true)),
            Arguments.of("User bets 19-36", halfBet(false)),
            Arguments.of("User bets 1-12", dozenBet(DozenBet.Dozen.FIRST)),
            Arguments.of("User bets 13-24", dozenBet(DozenBet.Dozen.SECOND)),
            Arguments.of("User bets 25-36", dozenBet(DozenBet.Dozen.THIRD)),
            Arguments.of("User bets FIRST COLUMN", columnBet(ColumnBet.Column.FIRST)),
            Arguments.of("User bets SECOND COLUMN", columnBet(ColumnBet.Column.SECOND)),
            Arguments.of("User bets THIRD COLUMN", columnBet(ColumnBet.Column.THIRD)),
            Arguments.of("User always bets ZERO", singleBet(ZERO)),
            Arguments.of("User always bets 17 BLACK", singleBet(BLACK_17))
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

    private static ColorBet colorBet(Field.Color color) {
        return new ColorBet(BET, color);
    }

    private static EvenBet evenBet(boolean even) {
        return new EvenBet(BET, even);
    }

    private static HalfBet halfBet(boolean firstHalf) {
        return new HalfBet(BET, firstHalf);
    }

    private static Bet dozenBet(DozenBet.Dozen dozen) {
        return new DozenBet(BET, dozen);
    }

    private static Bet columnBet(ColumnBet.Column column) {
        return new ColumnBet(BET, column);
    }

    private static Bet singleBet(Field field) {
        return new SingleBet(BET, field);
    }
}