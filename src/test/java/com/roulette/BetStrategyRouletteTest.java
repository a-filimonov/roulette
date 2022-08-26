package com.roulette;

import java.util.function.Supplier;
import java.util.stream.Stream;

import com.roulette.core.bet.Bet;
import com.roulette.core.bet.Factor;
import com.roulette.core.bet.strategy.BetStrategy;
import com.roulette.core.bet.strategy.nowin.DoubleBetColorStrategy;
import com.roulette.core.bet.strategy.win.DalembertStrategy;
import com.roulette.core.bet.strategy.win.FibonacciStrategy;
import com.roulette.core.bet.strategy.win.GrandMartingaleStrategy;
import com.roulette.core.bet.strategy.win.JamesBondStrategy;
import com.roulette.core.bet.strategy.win.MartingaleStrategy;
import com.roulette.core.bet.strategy.win.ReverseMartingaleStrategy;
import com.roulette.core.user.User;
import com.roulette.util.Boolean;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Named.named;
import static org.junit.jupiter.params.provider.Arguments.of;

public class BetStrategyRouletteTest extends BaseRouletteTest {

    @ParameterizedTest
    @MethodSource
    void shouldPlayRouletteWithGivenBetStrategy(Supplier<BetStrategy<Factor>> supplier) {
        for (int i = 0; i < ITERATIONS; i++) {
            User user = new User(supplier.get().getName(), BALANCE);
            Roulette roulette = roulette(user);
            play(roulette, supplier.get());
            STATS.register(user, roulette);
        }
    }

    private static Stream<Arguments> shouldPlayRouletteWithGivenBetStrategy() {
        var bet = colorBet(Boolean.TRUE);
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
            of(named(grandMartingale.get().getName(), grandMartingale)),
            of(named(fibonacci.get().getName(), fibonacci)),
            of(named(jamesBond.get().getName(), jamesBond)),
            of(named(doubleBetColor.get().getName(), doubleBetColor))
        );
    }

    private static Supplier<BetStrategy<Boolean>> dalembert(Bet<Boolean> bet) {
        return () -> new DalembertStrategy(bet);
    }

    private static Supplier<BetStrategy<Boolean>> martingale(Bet<Boolean> bet) {
        return () -> new MartingaleStrategy(bet);
    }

    private static Supplier<BetStrategy<Boolean>> reverseMartingale(Bet<Boolean> bet) {
        return () -> new ReverseMartingaleStrategy(bet);
    }

    private static Supplier<BetStrategy<Boolean>> grandMartingale(Bet<Boolean> bet) {
        return () -> new GrandMartingaleStrategy(bet);
    }

    private static Supplier<BetStrategy<Boolean>> fibonacci(Bet<Boolean> bet) {
        return () -> new FibonacciStrategy(bet);
    }

    private static Supplier<BetStrategy<Boolean>> doubleBetColor(Bet<Boolean> bet) {
        return () -> new DoubleBetColorStrategy(bet);
    }

    private static Supplier<BetStrategy<Factor>> jamesBond() {
        return JamesBondStrategy::new;
    }
}
