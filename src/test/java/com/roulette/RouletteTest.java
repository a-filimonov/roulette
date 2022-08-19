package com.roulette;

import java.util.function.Function;

import com.roulette.bet.ColorBet;
import com.roulette.strategy.*;
import org.junit.jupiter.api.Test;

import static com.roulette.Field.Color.*;

class RouletteTest {

    private static final long BALANCE = 1000;
    private static final long BET = 15;
    private static final boolean DEBUG = false;
    private static final int ITERATIONS = 100;

    @Test
    void testRoulette() {
        for (int i = 0; i < ITERATIONS; i++) {
//            play(roulette("Always RED"), bet -> bet(RED));
//            play(roulette("Always Random"), bet -> bet(random()));
//            play(roulette("Martingale RED"), new MartingaleStrategy(bet(RED)));
            play(roulette("Double RED"), new DoubleBetColorStrategy(bet(RED)));
        }
    }

    private static void play(Roulette roulette, Function<Long, ColorBet> betFunction) {
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

    private static ColorBet bet(Field.Color color) {
        return new ColorBet(BET, color);
    }
}