package com.roulette;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

import com.roulette.core.bet.Bet;
import com.roulette.core.bet.inside.CornerBet;
import com.roulette.core.bet.inside.LineBet;
import com.roulette.core.bet.inside.SingleBet;
import com.roulette.core.bet.inside.SplitBet;
import com.roulette.core.bet.inside.StreetBet;
import com.roulette.core.bet.outisde.bool.ColorBet;
import com.roulette.core.bet.outisde.ColumnBet;
import com.roulette.core.bet.outisde.DozenBet;
import com.roulette.core.bet.outisde.bool.BooleanBet;
import com.roulette.core.bet.outisde.bool.EvenBet;
import com.roulette.core.bet.outisde.bool.HalfBet;
import com.roulette.core.bet.strategy.BetStrategy;
import com.roulette.core.bet.strategy.nowin.RandomColor;
import com.roulette.core.bet.strategy.nowin.RandomColumn;
import com.roulette.core.bet.strategy.nowin.RandomCorner;
import com.roulette.core.bet.strategy.nowin.RandomDozen;
import com.roulette.core.bet.strategy.nowin.RandomField;
import com.roulette.core.bet.strategy.nowin.RandomHalf;
import com.roulette.core.bet.strategy.nowin.RandomLine;
import com.roulette.core.bet.strategy.nowin.RandomOddEven;
import com.roulette.core.bet.strategy.nowin.RandomSplit;
import com.roulette.core.bet.strategy.nowin.RandomStreet;
import com.roulette.core.field.Corner;
import com.roulette.core.field.Field;
import com.roulette.core.field.Line;
import com.roulette.core.field.Split;
import com.roulette.core.field.Street;
import com.roulette.core.user.User;
import com.roulette.exception.EndGameException;
import com.roulette.log.Log;
import com.roulette.stats.Stats;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static com.roulette.BetStrategies.dalembert;
import static com.roulette.BetStrategies.doubleBetColor;
import static com.roulette.BetStrategies.fibonacci;
import static com.roulette.BetStrategies.grandMartingale;
import static com.roulette.BetStrategies.jamesBond;
import static com.roulette.BetStrategies.martingale;
import static com.roulette.BetStrategies.reverseMartingale;
import static com.roulette.core.field.CornerRegistry.C_14_15_17_18;
import static com.roulette.core.field.FieldRegistry.F_17;
import static com.roulette.core.field.FieldRegistry.ZERO;
import static com.roulette.core.field.LineRegistry.L_10_15;
import static com.roulette.core.field.SplitRegistry.S_1_2;
import static com.roulette.core.field.StreetRegistry.S_13_14_15;
import static org.junit.jupiter.api.Named.named;
import static org.junit.jupiter.params.provider.Arguments.of;

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
            e.getValue().stream().sorted((rs1, rs2) -> (int) (rs2.payout() - rs1.payout()))
                .forEach(stat -> System.out.printf("\tStats: %s\n", stat));
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
    @MethodSource(value = "randomBetTestCases")
    void shouldPlayRouletteWithRandomBet(BetStrategy betStrategy) {
        for (int i = 0; i < ITERATIONS; i++) {
            play(roulette(betStrategy.getName()), betStrategy);
        }
    }

    @ParameterizedTest
    @MethodSource(value = "betStrategyTestCases")
    void shouldPlayRouletteWithGivenBetStrategy(Supplier<BetStrategy> supplier) {
        for (int i = 0; i < ITERATIONS; i++) {
            play(roulette(supplier.get().getName()), supplier.get());
        }
    }

    private static Stream<Arguments> betTestCases() {
        return Stream.of(
            of(colorBet(true)),
            of(colorBet(false)),
            of(evenBet(true)),
            of(evenBet(false)),
            of(halfBet(true)),
            of(halfBet(false)),
            of(dozenBet(Field.Dozen.D1)),
            of(dozenBet(Field.Dozen.D2)),
            of(dozenBet(Field.Dozen.D3)),
            of(columnBet(Field.Column.C1)),
            of(columnBet(Field.Column.C2)),
            of(columnBet(Field.Column.C3)),
            of(singleBet(ZERO)),    //TODO fix only one iteration
            of(singleBet(F_17)),
            of(splitBet(S_1_2)),
            of(streetBet(S_13_14_15)),
            of(cornerBet(C_14_15_17_18)),
            of(lineBet(L_10_15))
        );
    }

    private static Stream<Arguments> betStrategyTestCases() {
        var bet = colorBet(true);
        var dalembert = dalembert(bet);
        var martingale = martingale(bet);
        var reverseMartingale = reverseMartingale(bet);
        var grandMartingale = grandMartingale(bet);
        var fibonacci = fibonacci(bet);
        var jamesBond = jamesBond();
        var doubleBetColor = doubleBetColor(bet);

        return Stream.of(
            of(named(martingale.get().getName(), martingale)),
            of(named(dalembert.get().getName(), dalembert)),
            of(named(reverseMartingale.get().getName(), reverseMartingale)),
            of(named(grandMartingale.get().getName(), grandMartingale)),    //TODO fix 4 iterations
            of(named(fibonacci.get().getName(), fibonacci)),
            of(named(jamesBond.get().getName(), jamesBond)),
            of(named(doubleBetColor.get().getName(), doubleBetColor))
        );
    }

    private static Stream<Arguments> randomBetTestCases() {
        return Stream.of(
            of(new RandomColor(BET)),
            of(new RandomOddEven(BET)),
            of(new RandomHalf(BET)),
            of(new RandomDozen(BET)),
            of(new RandomColumn(BET)),
            of(new RandomSplit(BET)),
            of(new RandomField(BET)),   //TODO fix only 4 iterations
            of(new RandomStreet(BET)),
            of(new RandomCorner(BET)),
            of(new RandomLine(BET))
        );
    }

    private static void play(Roulette roulette, Bet bet) {
        try {
            while (true) {
                roulette.play(List.of(bet));
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

    private static BooleanBet colorBet(boolean isRed) {
        return new ColorBet(BET, isRed);
    }

    private static BooleanBet evenBet(boolean even) {
        return new EvenBet(BET, even);
    }

    private static BooleanBet halfBet(boolean firstHalf) {
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

    private static Bet streetBet(Street street) {
        return new StreetBet(BET, street);
    }

    private static Bet cornerBet(Corner corner) {
        return new CornerBet(BET, corner);
    }

    private static Bet lineBet(Line line) {
        return new LineBet(BET, line);
    }
}