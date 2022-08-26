package com.roulette;

import java.util.List;

import com.roulette.core.bet.Bet;
import com.roulette.core.bet.Factor;
import com.roulette.core.bet.inside.CornerBet;
import com.roulette.core.bet.inside.FieldBet;
import com.roulette.core.bet.inside.LineBet;
import com.roulette.core.bet.inside.SplitBet;
import com.roulette.core.bet.inside.StreetBet;
import com.roulette.core.bet.outisde.ColorBet;
import com.roulette.core.bet.outisde.ColumnBet;
import com.roulette.core.bet.outisde.DozenBet;
import com.roulette.core.bet.outisde.EvenBet;
import com.roulette.core.bet.outisde.HalfBet;
import com.roulette.core.bet.strategy.BetStrategy;
import com.roulette.core.field.Corner;
import com.roulette.core.field.Field;
import com.roulette.core.field.Line;
import com.roulette.core.field.Split;
import com.roulette.core.field.Street;
import com.roulette.core.user.User;
import com.roulette.exception.EndGameException;
import com.roulette.log.Log;
import com.roulette.stats.Stats;
import com.roulette.util.Boolean;
import org.junit.jupiter.api.AfterAll;

abstract class BaseRouletteTest {

    protected static final long BET = 15;
    protected static final int ITERATIONS = 10; // how many games each user plays specified strategy
    private static final int LIMIT = 10; // game results are sorted by payout, show only top N in the end

    protected static final long BALANCE = 1000;
    private static final boolean DEBUG = false;
    protected static final Stats STATS = new Stats();

    @AfterAll
    static void end() {
        STATS.getAll().entrySet().forEach(e -> {
            String name = e.getKey().getName();
            System.out.printf("Roulette [%s]:\n", name);
            e.getValue().stream().sorted((rs1, rs2) -> (int) (rs2.payout() - rs1.payout()))
                .limit(LIMIT)
                .forEach(stat -> System.out.printf("\tStats: %s\n", stat));
        });
    }

    protected static void play(Roulette roulette, BetStrategy<Factor> betStrategy) {
        try {
            Long win = roulette.play(betStrategy.apply(10L));
            while (true) {
                win = roulette.play(betStrategy.apply(win));
            }
        } catch (EndGameException e) {
            // stop roulette
        }
    }

    protected static Roulette roulette(User user) {
        return new Roulette(user, new Log(DEBUG));
    }

    protected static Bet<Boolean> colorBet(Boolean isRed) {
        return new ColorBet(BET, isRed);
    }

    protected static Bet<Boolean> evenBet(Boolean even) {
        return new EvenBet(BET, even);
    }

    protected static Bet<Boolean> halfBet(Boolean firstHalf) {
        return new HalfBet(BET, firstHalf);
    }

    protected static Bet<Field.Dozen> dozenBet(Field.Dozen dozen) {
        return new DozenBet(BET, dozen);
    }

    protected static Bet<Field.Column> columnBet(Field.Column column) {
        return new ColumnBet(BET, column);
    }

    protected static Bet<Field> singleBet(Field field) {
        return new FieldBet(BET, field);
    }

    protected static Bet<Split> splitBet(Split split) {
        return new SplitBet(BET, split);
    }

    protected static Bet<Street> streetBet(Street street) {
        return new StreetBet(BET, street);
    }

    protected static Bet<Corner> cornerBet(Corner corner) {
        return new CornerBet(BET, corner);
    }

    protected static Bet<Line> lineBet(Line line) {
        return new LineBet(BET, line);
    }
}