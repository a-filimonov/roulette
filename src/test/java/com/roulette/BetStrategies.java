package com.roulette;

import java.util.function.Supplier;

import com.roulette.core.bet.outisde.bool.BooleanBet;
import com.roulette.core.bet.strategy.BetStrategy;
import com.roulette.core.bet.strategy.nowin.DoubleBetColorStrategy;
import com.roulette.core.bet.strategy.win.DalembertStrategy;
import com.roulette.core.bet.strategy.win.FibonacciStrategy;
import com.roulette.core.bet.strategy.win.GrandMartingaleStrategy;
import com.roulette.core.bet.strategy.win.JamesBondStrategy;
import com.roulette.core.bet.strategy.win.MartingaleStrategy;
import com.roulette.core.bet.strategy.win.ReverseMartingaleStrategy;

public class BetStrategies {
    public static Supplier<BetStrategy> dalembert(BooleanBet bet) {
        return () -> new DalembertStrategy(bet);
    }

    public static Supplier<BetStrategy> martingale(BooleanBet bet) {
        return () -> new MartingaleStrategy(bet);
    }

    public static Supplier<BetStrategy> reverseMartingale(BooleanBet bet) {
        return () -> new ReverseMartingaleStrategy(bet);
    }

    public static Supplier<BetStrategy> grandMartingale(BooleanBet bet) {
        return () -> new GrandMartingaleStrategy(bet);
    }

    public static Supplier<BetStrategy> fibonacci(BooleanBet bet) {
        return () -> new FibonacciStrategy(bet);
    }

    public static Supplier<BetStrategy> doubleBetColor(BooleanBet bet) {
        return () -> new DoubleBetColorStrategy(bet);
    }

    public static Supplier<BetStrategy> jamesBond() {
        return JamesBondStrategy::new;
    }
}
