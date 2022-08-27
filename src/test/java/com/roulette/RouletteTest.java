package com.roulette;

import java.util.Collection;
import java.util.List;

import com.roulette.core.user.User;
import com.roulette.log.Log;
import com.roulette.stats.UserStats;
import org.junit.jupiter.api.Test;

import static com.roulette.core.user.UserRegistry.RANDOM_BET_USERS;
import static com.roulette.core.user.UserRegistry.SAME_BET_USERS;
import static com.roulette.core.user.UserRegistry.WIN_STRATEGY_USERS;

class RouletteTest {

    private static final boolean DEBUG = false;

    @Test
    void shouldPlayRouletteWithBetStrategy() {
        print(roulette(WIN_STRATEGY_USERS).play());
    }

    @Test
    void shouldPlayRouletteWithRandomBet() {
        print(roulette(RANDOM_BET_USERS).play());
    }

    @Test
    void shouldPlayRouletteWithSameBet() {
        print(roulette(SAME_BET_USERS).play());
    }

    private static void print(Collection<UserStats> stats) {
        stats.forEach(stat -> {
            User user = stat.getUser();
            System.out.printf("%s plays [%s] strategy: %s\n", user.getName(), user.getStrategy().getName(), stat);
        });
    }

    private static Roulette roulette(List<User> users) {
        return new Roulette(users, new Log(DEBUG));
    }
}