package com.roulette;

import java.util.function.Function;

import com.roulette.bet.Bet;
import com.roulette.bet.ColorBet;
import com.roulette.bet.EvenBet;
import com.roulette.bet.HalfBet;
import com.roulette.strategy.DoubleBetColorStrategy;
import com.roulette.strategy.MartingaleStrategy;
import org.junit.jupiter.api.RepeatedTest;

import static com.roulette.Field.Color.BLACK;
import static com.roulette.Field.Color.RED;
import static com.roulette.Field.Color.random;

class RouletteTest {

    private static final long BALANCE = 1000;
    private static final long BET = 15;
    private static final boolean DEBUG = false;
    private static final int ITERATIONS = 10;

    @RepeatedTest(ITERATIONS)
    void roulette_always_bet_red() {
        play(roulette("Always RED"), bet -> colorBet(RED));
    }

    @RepeatedTest(ITERATIONS)
    void roulette_always_bet_black() {
        play(roulette("Always BLACK"), bet -> colorBet(BLACK));
    }

    @RepeatedTest(ITERATIONS)
    void roulette_always_bet_random_color() {
        play(roulette("Always Random"), bet -> colorBet(random()));
    }

    @RepeatedTest(ITERATIONS)
    void roulette_always_bet_even() {
        play(roulette("Always EVEN"), bet -> evenBet(true));
    }

    @RepeatedTest(ITERATIONS)
    void roulette_always_bet_odd() {
        play(roulette("Always ODD"), bet -> evenBet(false));
    }

    @RepeatedTest(ITERATIONS)
    void roulette_always_bet_first_half() {
        play(roulette("Always FIRST HALF"), bet -> halfBet(true));
    }

    @RepeatedTest(ITERATIONS)
    void roulette_always_bet_second_half() {
        play(roulette("Always SECOND_HALF"), bet -> halfBet(false));
    }

    @RepeatedTest(ITERATIONS)
    void roulette_double_bet_when_lost_martingale_strategy() {
        play(roulette("Martingale RED"), new MartingaleStrategy(colorBet(RED)));
    }

    @RepeatedTest(ITERATIONS)
    void roulette_always_double_bet() {
        play(roulette("Double RED"), new DoubleBetColorStrategy(colorBet(RED)));
    }

    private static void play(Roulette roulette, Function<Long, Bet> betFunction) {
        try {
            Long win = roulette.play(betFunction.apply(10L));
            while (true) {
                win = roulette.play(betFunction.apply(win));
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    private static Roulette roulette(String name) {
        return new Roulette(new User(name, BALANCE), DEBUG);
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
}