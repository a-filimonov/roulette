package com.roulette.stats;

import com.roulette.core.user.User;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(of = "user")
public class UserStats implements Comparable<UserStats> {
    private final User user;
    private final long initBalance;

    private int wins;
    private int loses;
    private int totalBet;
    private int totalWin;
    private long maxBalance;

    public UserStats(User user) {
        this.user = user;
        this.initBalance = user.getBalance();
        this.maxBalance = user.getBalance();
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
        if (totalBet == 0) {
            return 0;
        }
        return totalWin * 100d / totalBet;
    }

    public long profit() {
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
        return String.format("W%s/L%s WinRate [%.2f] Profit [%s] Payout [%.2f%%]", wins, loses, winRate(), profit(), payout());
    }

    @Override
    public int compareTo(UserStats otherStats) {
        return (int) this.payout() - (int) otherStats.payout();
    }
}
