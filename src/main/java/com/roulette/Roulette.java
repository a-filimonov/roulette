package com.roulette;

import java.util.UUID;

import com.roulette.bet.Bet;
import com.roulette.exception.EndGameException;
import com.roulette.stats.Stats;
import lombok.Getter;

public class Roulette {

    @Getter
    private final String id;
    private final User user;
    private final boolean debug;
    @Getter
    private final Stats.RouletteStats stats;
    private final RouletteWheel wheel;

    public Roulette(User user, boolean debug) {
        this.id = user.getName();
        this.user = user;
        this.debug = debug;
        this.stats = new Stats.RouletteStats();
        this.wheel = new RouletteWheel(stats);
    }

    public Long play(Bet bet) {
        Field field = wheel.turn();
        debug("Turn %s :: [%s] :: ", stats.getTurns(), field);

        var totalBet = bet.getBet();
        if (!user.isAbleToBet(totalBet)) {
            throw new EndGameException(user);
        }
        user.bet(totalBet);
        stats.addBet(totalBet);
        debug("User %s bets %s on %s :: ", user.getName(), totalBet, bet);

        long win = new Paytable(field).process(bet);

        if (win > 0) {
            long balance = user.win(win);
            stats.addWin(win);
            stats.updateMaxBalance(balance);
            debug("User won %s. ", win);
        } else {
            stats.lost();
            debug("User lost %s. ", totalBet);
        }

        debugln("Balance: %s", user.getBalance());

        return win;
    }

    private void debug(String str, Object... args) {
        if (debug) {
            System.out.printf(str, args);
        }
    }

    private void debugln(String str, Object... args) {
        if (debug) {
            System.out.printf((str) + "%n", args);
        }
    }
}
