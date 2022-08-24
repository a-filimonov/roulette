package com.roulette.stats;

import com.roulette.Roulette;
import com.roulette.core.user.User;
import com.roulette.util.MultiMap;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class Stats {

    //TODO sort stats by profitability
    private static final MultiMap<User, RouletteStats> ROULETTE_STATS = new MultiMap<>();

    public MultiMap<User, RouletteStats> getAll() {
        return ROULETTE_STATS;
    }

    public void register(User user, Roulette roulette) {
        ROULETTE_STATS.add(user, roulette.getStats());
    }

    @Getter
    @NoArgsConstructor
    public static class RouletteStats {
        private int turns;
        private int wins;
        private int loses;
        private int totalBet;
        private int totalWin;
        private long initBalance;
        private long maxBalance;
        private int profitTurn;

        public RouletteStats(long initBalance) {
            this.initBalance = initBalance;
        }

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
                this.profitTurn = turns;
            }
        }

        public double payout() {
            return totalWin * 100d / totalBet;
        }

        public double avgBet() {
            return ((float) totalBet) / turns;
        }

        private long profit() {
            return maxBalance - initBalance;
        }

        @Override
        public String toString() {
            return String.format("Stats: W%s/L%s(T%s), PROFIT %s(@%s), BET %.2f, PAYOUT %.2f%%", wins, loses, turns, profit(), profitTurn, avgBet(), payout());
        }
    }
}
