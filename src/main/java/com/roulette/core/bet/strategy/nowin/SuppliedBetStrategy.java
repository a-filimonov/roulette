package com.roulette.core.bet.strategy.nowin;

import java.util.function.Supplier;

import com.roulette.core.bet.Bet;
import com.roulette.core.bet.Factor;
import lombok.Getter;

public class SuppliedBetStrategy<F extends Factor> extends NoWinBetStrategy<F> {

    private final BetSupplier<F> betSupplier;

    public SuppliedBetStrategy(String name, Supplier<Bet<F>> supplier) {
        super(0L);
        this.betSupplier = new BetSupplier<>(name, supplier);
    }

    @Override
    public String getName() {
        return betSupplier.getName();
    }

    @Override
    public Bet<F> apply() {
        return betSupplier.get();
    }

    public static class BetSupplier<F extends Factor> implements Supplier<Bet<F>> {

        @Getter
        private final String name;
        private final Supplier<Bet<F>> supplier;

        public BetSupplier(String name, Supplier<Bet<F>> supplier) {
            this.name = name;
            this.supplier = supplier;
        }

        @Override
        public Bet<F> get() {
            return supplier.get();
        }
    }
}
