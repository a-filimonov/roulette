package com.roulette;

import com.roulette.bet.ColorBet;

public class Roulette {

    private final User user;
    private final boolean debug;
    private final RouletteEngine engine;

    private int wins;
    private int loses;

    public Roulette(User user, boolean debug) {
        this.user = user;
        this.debug = debug;
        this.engine = new RouletteEngine();
    }

    public Long play(ColorBet bet) {
        Field field = engine.turn();
        debug("Turn %s :: [%s] :: ", engine.getTurns(), field);

        return processBet(new Paytable(field), bet);
    }

    private Long processBet(Paytable paytable, ColorBet bet) {
        var totalBet = bet.getBet();
        if (!user.isAbleToBet(totalBet)) {
            throw new RuntimeException(String.format("User %s lost all money. Wins: [%s]. Loses: [%s]. Max balance: [%s]", user.getName(), wins, loses, user.getMaxBalance()));
        }
        user.bet(totalBet);
        debug("User %s bets %s on %s :: ", user.getName(), totalBet, bet.getColor());

        long win = paytable.process(bet);
        user.win(win);
        if (win > 0) {
            wins++;
            debug("User won %s. ", win);
        } else {
            loses++;
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
