package com.roulette.stats;

import com.roulette.Roulette;
import com.roulette.core.user.User;
import com.roulette.util.SortedMultiMap;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class Stats {

    private static final SortedMultiMap<User, RouletteStats> ROULETTE_STATS = new SortedMultiMap<>();

    public SortedMultiMap<User, RouletteStats> getAll() {
        return ROULETTE_STATS;
    }

    public void register(User user, Roulette roulette) {
        //TODO 0-stats are preventing from further adds
        ROULETTE_STATS.add(user, roulette.getStats());
    }

    @Getter
    @NoArgsConstructor
    @EqualsAndHashCode(of = "id")
    public static class RouletteStats implements Comparable<RouletteStats> {
        private String id;
        private int turns;
        private int wins;
        private int loses;
        private int totalBet;
        private int totalWin;
        private long initBalance;
        private long maxBalance;
        private int profitTurn;

        public RouletteStats(String id, long initBalance) {
            this.id = id;
            this.initBalance = initBalance;
            this.maxBalance = initBalance;
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
            if (totalBet == 0) {
                return 0;
            }
            return totalWin * 100d / totalBet;
        }

        public double avgBet() {
            return ((float) totalBet) / turns;
        }

        private long profit() {
            return maxBalance - initBalance;
        }

        private float winRate() {
            if (loses == 0) {
                return 0;
            }
            return (float) wins / loses;
        }

        @Override
        public String toString() {
            return String.format("W%s/L%s(T%s) WinRate [%.2f] Profit [%s @ %s turn] Avg Bet [%.2f] Payout [%.2f%%]", wins, loses, turns, winRate(), profit(), profitTurn, avgBet(), payout());
        }

        @Override
        public int compareTo(RouletteStats otherStats) {
            return (int) this.payout() - (int) otherStats.payout();
        }
    }
}
