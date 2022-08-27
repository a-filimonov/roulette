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

import static java.util.stream.Collectors.toMap;

public class Roulette {

    private final List<User> users;
    private final Map<User, UserStats> userStats;
    private final Log log;
    private final RouletteWheel wheel;

    public Roulette(List<User> users, Log log) {
        this.users = users;
        this.log = log;
        this.wheel = new RouletteWheel();
        this.userStats = users.stream().collect(toMap(Function.identity(), UserStats::new));
    }

    public Collection<UserStats> play() {
        while (users.stream().anyMatch(User::hasMoney)) {
            play(users);
        }

        return userStats.values();
    }

    private void play(List<User> users) {
        var userBets = users.stream()
            .collect(toMap(Function.identity(), user -> user.getStrategy().apply(user.getLastWin())));

        Field field = wheel.turn();
        log.debugln("Turn :: [%s]", field);

        userBets.keySet().forEach(user -> play(userBets.get(user), field, user));
    }

    private void play(Bet<?> bet, Field field, User user) {
        var stats = userStats.get(user);
        if (!user.hasMoney()) {
            return;
        }

        user.bet(bet.getBet());
        stats.addBet(bet.getBet());
        log.debug(" :: %s's bet was [%s on %s] :: ", user.getName(), bet.getBet(), bet);

        long win = bet.pay(field);

        if (win > 0) {
            long balance = user.win(win);
            stats.addWin(win);
            stats.updateMaxBalance(balance);
            log.debug("WON %s !!! ", win);
        } else {
            stats.lost();
            log.debug("Lost %s. ", bet.getBet());
        }

        log.debugln("Balance: %s", user.getBalance());
        user.setLastWin(win);
    }
}
