package com.roulette;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import com.roulette.core.user.User;
import com.roulette.log.Log;
import com.roulette.stats.UserStats;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static com.roulette.core.user.UserRegistry.RANDOM_BETS_USERS;
import static com.roulette.core.user.UserRegistry.RANDOM_BET_FACTOR_USERS;
import static com.roulette.core.user.UserRegistry.SAME_BET_USERS;
import static com.roulette.core.user.UserRegistry.WIN_STRATEGY_USERS;
import static java.util.stream.Collectors.toMap;
import static org.junit.jupiter.api.Named.named;
import static org.junit.jupiter.params.provider.Arguments.of;

class RouletteTest {

    private static final Log LOG = new Log(false);

    @ParameterizedTest
    @MethodSource
    void shouldPlayRouletteForUserList(List<User> users) {
        Roulette roulette = new Roulette(users, LOG);
        Long initialCasinoBalance = roulette.getBalance();
        print(roulette.play());
        LOG.infoln("Casino profit after game: %s", roulette.getBalance() - initialCasinoBalance);
        LOG.infoln("User balances after game: %s\n", users.stream().collect(toMap(User::getName, User::getBalance)));
    }

    private static Stream<Arguments> shouldPlayRouletteForUserList() {
        return Stream.of(
            of(named("Users play different win strategies", WIN_STRATEGY_USERS)),
            of(named("Users always bet the same", SAME_BET_USERS)),
            of(named("Users bet random factors", RANDOM_BET_FACTOR_USERS)),
            of(named("Users bet totally random", RANDOM_BETS_USERS))
        );
    }

    private static void print(Collection<UserStats> stats) {
        stats.stream().sorted((s1, s2) -> (int) (s2.profit() - s1.profit())).forEach(stat -> {
            User user = stat.getUser();
            LOG.infoln("%s played [%s] strategy: %s", user.getName(), user.getStrategy().getName(), stat);
        });
    }
}