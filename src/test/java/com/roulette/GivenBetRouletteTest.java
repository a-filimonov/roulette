package com.roulette;

import java.util.List;
import java.util.stream.Stream;

import com.roulette.core.bet.Bet;
import com.roulette.core.bet.Factor;
import com.roulette.core.field.Field;
import com.roulette.core.user.User;
import com.roulette.exception.EndGameException;
import com.roulette.util.Boolean;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static com.roulette.core.field.CornerRegistry.C_14_15_17_18;
import static com.roulette.core.field.FieldRegistry.F_17;
import static com.roulette.core.field.FieldRegistry.ZERO;
import static com.roulette.core.field.LineRegistry.L_10_15;
import static com.roulette.core.field.SplitRegistry.S_1_2;
import static com.roulette.core.field.StreetRegistry.S_13_14_15;
import static org.junit.jupiter.params.provider.Arguments.of;

public class GivenBetRouletteTest extends BaseRouletteTest {

    @ParameterizedTest
    @MethodSource
    void shouldPlayRouletteWithGivenBet(Bet<Factor> bet) {
        for (int i = 0; i < ITERATIONS; i++) {
            User user = new User("All bets on " + bet.toString(), BALANCE);
            Roulette roulette = roulette(user);
            play(roulette, bet);
            STATS.register(user, roulette);
        }
    }

    private static void play(Roulette roulette, Bet<Factor> bet) {
        try {
            while (true) {
                roulette.play(List.of(bet));
            }
        } catch (EndGameException e) {
            // stop roulette
        }
    }

    private static Stream<Arguments> shouldPlayRouletteWithGivenBet() {
        return Stream.of(
            of(colorBet(Boolean.TRUE)),
            of(colorBet(Boolean.FALSE)),
            of(evenBet(Boolean.TRUE)),
            of(evenBet(Boolean.FALSE)),
            of(halfBet(Boolean.TRUE)),
            of(halfBet(Boolean.FALSE)),
            of(dozenBet(Field.Dozen.D1)),
            of(dozenBet(Field.Dozen.D2)),
            of(dozenBet(Field.Dozen.D3)),
            of(columnBet(Field.Column.C1)),
            of(columnBet(Field.Column.C2)),
            of(columnBet(Field.Column.C3)),
            of(singleBet(ZERO)),
            of(singleBet(F_17)),
            of(splitBet(S_1_2)),
            of(streetBet(S_13_14_15)),
            of(cornerBet(C_14_15_17_18)),
            of(lineBet(L_10_15))
        );
    }
}
