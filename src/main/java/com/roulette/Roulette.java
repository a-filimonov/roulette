package com.roulette;

import java.util.UUID;

import com.roulette.bet.Bet;
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
        this.stats = new Stats.RouletteStats();
        this.wheel = new RouletteWheel(stats);
    }

    public Long play(Bet bet) {
        Field field = wheel.turn();
        log.debug("%s :: [%s] :: ", stats.getTurns(), field);

        var totalBet = bet.getBet();
        if (!user.isAbleToBet(totalBet)) {
            throw new EndGameException(user);
        }
        user.bet(totalBet);
        stats.addBet(totalBet);
        log.debug("[%s] bets %s on %s :: ", user.getName(), totalBet, bet);

        long win = new Paytable(field).process(bet);

        if (win > 0) {
            long balance = user.win(win);
            stats.addWin(win);
            stats.updateMaxBalance(balance);
            log.debug("Won %s. ", win);
        } else {
            stats.lost();
            log.debug("Lost %s. ", totalBet);
        }

        log.debugln("Balance: %s", user.getBalance());

        return win;
    }

}
