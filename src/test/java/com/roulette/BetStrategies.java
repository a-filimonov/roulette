package com.roulette;

import java.util.function.Supplier;

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
import com.roulette.util.Boolean;

public class BetStrategies {
    public static Supplier<BetStrategy<Boolean>> dalembert(Bet<Boolean> bet) {
        return () -> new DalembertStrategy(bet);
    }

    public static Supplier<BetStrategy<Boolean>> martingale(Bet<Boolean> bet) {
        return () -> new MartingaleStrategy(bet);
    }

    public static Supplier<BetStrategy<Boolean>> reverseMartingale(Bet<Boolean> bet) {
        return () -> new ReverseMartingaleStrategy(bet);
    }

    public static Supplier<BetStrategy<Boolean>> grandMartingale(Bet<Boolean> bet) {
        return () -> new GrandMartingaleStrategy(bet);
    }

    public static Supplier<BetStrategy<Boolean>> fibonacci(Bet<Boolean> bet) {
        return () -> new FibonacciStrategy(bet);
    }

    public static Supplier<BetStrategy<Boolean>> doubleBetColor(Bet<Boolean> bet) {
        return () -> new DoubleBetColorStrategy(bet);
    }

    public static Supplier<BetStrategy<Factor>> jamesBond() {
        return JamesBondStrategy::new;
    }
}
