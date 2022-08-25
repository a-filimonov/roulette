package com.roulette;

import java.util.function.Supplier;

import com.roulette.core.bet.outisde.ColorBet;
import com.roulette.core.bet.strategy.BetStrategy;
import com.roulette.core.bet.strategy.nowin.DoubleBetColorStrategy;
import com.roulette.core.bet.strategy.win.DalembertStrategy;
import com.roulette.core.bet.strategy.win.FibonacciStrategy;
import com.roulette.core.bet.strategy.win.GrandMartingaleStrategy;
import com.roulette.core.bet.strategy.win.JamesBondStrategy;
import com.roulette.core.bet.strategy.win.MartingaleStrategy;
import com.roulette.core.bet.strategy.win.ReverseMartingaleStrategy;

public class BetStrategies {
    public static Supplier<BetStrategy> dalembert(ColorBet bet) {
        return () -> new DalembertStrategy(bet);
    }

    public static Supplier<BetStrategy> martingale(ColorBet bet) {
        return () -> new MartingaleStrategy(bet);
    }

    public static Supplier<BetStrategy> reverseMartingale(ColorBet bet) {
        return () -> new ReverseMartingaleStrategy(bet);
    }

    public static Supplier<BetStrategy> grandMartingale(ColorBet bet) {
        return () -> new GrandMartingaleStrategy(bet);
    }

    public static Supplier<BetStrategy> fibonacci(ColorBet bet) {
        return () -> new FibonacciStrategy(bet);
    }

    public static Supplier<BetStrategy> doubleBetColor(ColorBet bet) {
        return () -> new DoubleBetColorStrategy(bet);
    }

    public static Supplier<BetStrategy> jamesBond() {
        return JamesBondStrategy::new;
    }
}
