package com.roulette.stats;

import java.util.HashMap;
import java.util.Map;

import com.roulette.Roulette;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

public class Stats {

    private static final Map<String, RouletteStats> ROULETTE_STATS = new HashMap<>();

    public RouletteStats get(String id) {
        return ROULETTE_STATS.get(id);
    }

    public Map<String, RouletteStats> getAll() {
        return ROULETTE_STATS;
    }

    public void register(Roulette roulette) {
        ROULETTE_STATS.put(roulette.getId(), roulette.getStats());
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
