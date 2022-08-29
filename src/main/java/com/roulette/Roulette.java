package com.roulette;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import com.roulette.core.RouletteWheel;
import com.roulette.core.bet.Bet;
import com.roulette.core.field.Field;
import com.roulette.core.user.User;
import com.roulette.log.Log;
import com.roulette.stats.UserStats;
import lombok.Getter;

import static java.util.function.Predicate.not;
import static java.util.stream.Collectors.toMap;

public class Roulette {

    private final List<User> users;
    private final Map<User, UserStats> userStats;
    private final Log log;
    private final RouletteWheel wheel;

    @Getter
    private Long balance;
    private int turns;

    public Roulette(List<User> users, Log log) {
        this.users = users;
        this.log = log;
        this.wheel = new RouletteWheel();
        this.userStats = users.stream().collect(toMap(Function.identity(), UserStats::new));
        this.balance = users.stream().mapToLong(User::getBalance).sum() * 10;
        log.infoln("Roulette initialized");
        log.infoln("Users: %s", users);
    }

    public Collection<UserStats> play() {
        while (!users.stream().allMatch(User::isBankrupt)) {
            play(users);
        }

        return userStats.values();
    }

    private void play(List<User> users) {
        // Users make their bets
        var userBets = users.stream()
            .filter(not(User::isBankrupt))
            .collect(toMap(Function.identity(), user -> user.getStrategy().apply(user.getLastWin())));

        // Roulette turns
        Field field = wheel.turn();
        turns++;

        if (users.size() > 1) {
            log.debugln("Turn %s :: [%s]", turns, field);
        } else {
            log.debug("Turn %s :: [%s]", turns, field);
        }

        // Casino calculates wins
        userBets.forEach((key, value) -> processWin(key, value, field));
    }

    private void processWin(User user, Bet<?> bet, Field field) {
        long betAmount = bet.getBet();
        if (!user.canBet(betAmount)) {
            log.debugln(" :: %s cannot bet %s. GAME OVER", user, betAmount);
            user.setBankrupt(true);
            return;
        }
        user.bet(betAmount);
        var stats = userStats.get(user);
        stats.addBet(betAmount);
        this.balance += betAmount;
        log.debug(" :: %s's bet was [%s on %s] :: ", user.getName(), betAmount, bet);

        long win = bet.pay(field);
        this.balance -= win;

        if (win > 0) {
            long balance = user.win(win);
            stats.addWin(win);
            stats.updateMaxBalance(balance);
            log.debug("WON %s !!! ", win);
        } else {
            stats.lost();
            log.debug("Lost %s. ", betAmount);
        }

        log.debugln("User Balance: %s, Roulette balance: %s", user.getBalance(), this.balance);
        user.setLastWin(win);
    }
}
