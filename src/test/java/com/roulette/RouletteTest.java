package com.roulette;

import java.util.function.Function;

import com.roulette.bet.Bet;
import com.roulette.bet.ColorBet;
import com.roulette.bet.ColumnBet;
import com.roulette.bet.DozenBet;
import com.roulette.bet.EvenBet;
import com.roulette.bet.HalfBet;
import com.roulette.exception.EndGameException;
import com.roulette.log.Log;
import com.roulette.stats.Stats;
import com.roulette.strategy.DoubleBetColorStrategy;
import com.roulette.strategy.MartingaleStrategy;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.RepeatedTest;

import static com.roulette.Field.Color.BLACK;
import static com.roulette.Field.Color.RED;
import static com.roulette.Field.Color.random;

class RouletteTest {

    private static final long BALANCE = 1000;
    private static final long BET = 15;
    private static final boolean DEBUG = false;
    private static final int ITERATIONS = 20;
    private static final Stats STATS = new Stats();

    @AfterAll
    static void end() {
        STATS.getAll().entrySet().forEach(e -> {
            String name = e.getKey().getName();
            System.out.printf("Roulette [%s]:\n", name);
            e.getValue().forEach(stat -> System.out.printf("\t%s. PAYOUT: %.2f%%\n", stat, stat.payout()));
        });
    }

    @RepeatedTest(ITERATIONS)
    void roulette_always_bet_red() {
        play(roulette("User bets always RED color"), bet -> colorBet(RED));
    }

    @RepeatedTest(ITERATIONS)
    void roulette_always_bet_black() {
        play(roulette("User bets always BLACK color"), bet -> colorBet(BLACK));
    }

    @RepeatedTest(ITERATIONS)
    void roulette_always_bet_random_color() {
        play(roulette("User bets random color"), bet -> colorBet(random()));
    }

    @RepeatedTest(ITERATIONS)
    void roulette_always_bet_even() {
        play(roulette("User bets always EVEN"), bet -> evenBet(true));
    }

    @RepeatedTest(ITERATIONS)
    void roulette_always_bet_odd() {
        play(roulette("User bets always ODD"), bet -> evenBet(false));
    }

    @RepeatedTest(ITERATIONS)
    void roulette_always_bet_first_half() {
        play(roulette("User bets 1-18"), bet -> halfBet(true));
    }

    @RepeatedTest(ITERATIONS)
    void roulette_always_bet_second_half() {
        play(roulette("User bets 19-36"), bet -> halfBet(false));
    }

    @RepeatedTest(ITERATIONS)
    void roulette_always_bet_first_dozen() {
        play(roulette("User bets 1-12"), bet -> dozenBet(DozenBet.Dozen.FIRST));
    }

    @RepeatedTest(ITERATIONS)
    void roulette_always_bet_second_dozen() {
        play(roulette("User bets 13-24"), bet -> dozenBet(DozenBet.Dozen.SECOND));
    }

    @RepeatedTest(ITERATIONS)
    void roulette_always_bet_third_dozen() {
        play(roulette("User bets 25-36"), bet -> dozenBet(DozenBet.Dozen.THIRD));
    }

    @RepeatedTest(ITERATIONS)
    void roulette_always_bet_first_column() {
        play(roulette("User bets FIRST COLUMN"), bet -> columnBet(ColumnBet.Column.FIRST));
    }

    @RepeatedTest(ITERATIONS)
    void roulette_always_bet_second_column() {
        play(roulette("User bets SECOND COLUMN"), bet -> columnBet(ColumnBet.Column.SECOND));
    }

    @RepeatedTest(ITERATIONS)
    void roulette_always_bet_third_column() {
        play(roulette("User bets THIRD COLUMN"), bet -> columnBet(ColumnBet.Column.THIRD));
    }

    @RepeatedTest(ITERATIONS)
    void roulette_double_bet_when_lost_martingale_strategy() {
        play(roulette("User bets by Martingale strategy"), new MartingaleStrategy(colorBet(RED)));
    }

    @RepeatedTest(ITERATIONS)
    void roulette_always_double_bet() {
        play(roulette("User always doubles the bet"), new DoubleBetColorStrategy(colorBet(RED)));
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
}