package com.roulette;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import com.roulette.core.bet.Bet;
import com.roulette.core.field.Field;
import com.roulette.core.RouletteWheel;
import com.roulette.core.user.User;
import com.roulette.exception.EndGameException;
import com.roulette.log.Log;
import com.roulette.stats.Stats;
import lombok.Getter;

public class Roulette {

    @Getter
    private final String id;
    private final User user;
    private final Log log;
    @Getter
    private final Stats.RouletteStats stats;
    private final RouletteWheel wheel;

    public Roulette(User user, Log log) {
        this.id = UUID.randomUUID().toString();
        this.user = user;
        this.log = log;
        this.stats = new Stats.RouletteStats(user.getBalance());
        this.wheel = new RouletteWheel(stats);
    }

    public long play(List<Bet> bets) {
        var totalBet = bets.stream().mapToLong(Bet::getBet).sum();
        if (!user.isAbleToBet(totalBet)) {
            throw new EndGameException(user);
        }

        Field field = wheel.turn();
        log.debug("%s :: ", stats.getTurns());

        user.bet(totalBet);
        stats.addBet(totalBet);
        bets.forEach(bet -> log.debug("[%s] bets %s on %s :: [%s] :: ", user.getName(), totalBet, bet, field));

        long totalWin = bets.stream().mapToLong(bet -> bet.pay(field)).sum();

        if (totalWin > 0) {
            long balance = user.win(totalWin);
            stats.addWin(totalWin);
            stats.updateMaxBalance(balance);
            log.debug("WON %s !!! ", totalWin);
        } else {
            stats.lost();
            log.debug("Lost %s. ", totalBet);
        }

        log.debugln("Balance: %s", user.getBalance());

        return totalWin;
    }

    public Long play(Bet... bets) {
        return play(Arrays.asList(bets));
    }
}
