package com.roulette.stats;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import com.roulette.Roulette;
import com.roulette.User;
import com.roulette.util.MultiMap;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

public class Stats {

    private static final MultiMap<User, RouletteStats> ROULETTE_STATS = new MultiMap<>();

    public MultiMap<User, RouletteStats> getAll() {
        return ROULETTE_STATS;
    }

    public void register(User user, Roulette roulette) {
        ROULETTE_STATS.add(user, roulette.getStats());
    }

    @Getter
    @NoArgsConstructor
    @ToString
    public static class RouletteStats {
        private int turns;
        private int wins;
        private int loses;
        private int totalBet;
        private int totalWin;
        private long maxBalance;

        public void addTurn() {
            turns++;
        }

        public void lost() {
            loses++;
        }

        public void addBet(long totalBet) {
            this.totalBet += totalBet;
        }

        public void addWin(long win) {
            this.wins++;
            this.totalWin += win;
        }

        public void updateMaxBalance(long balance) {
            if (balance > this.maxBalance) {
                this.maxBalance = balance;
            }
        }

        public double payout() {
            return totalWin * 100d / totalBet;
        }
    }
}
