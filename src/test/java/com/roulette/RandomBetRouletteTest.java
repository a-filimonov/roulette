package com.roulette;

import java.util.stream.Stream;

import com.roulette.core.bet.Factor;
import com.roulette.core.bet.strategy.BetStrategy;
import com.roulette.core.bet.strategy.nowin.RandomColor;
import com.roulette.core.bet.strategy.nowin.RandomColumn;
import com.roulette.core.bet.strategy.nowin.RandomCorner;
import com.roulette.core.bet.strategy.nowin.RandomDozen;
import com.roulette.core.bet.strategy.nowin.RandomField;
import com.roulette.core.bet.strategy.nowin.RandomHalf;
import com.roulette.core.bet.strategy.nowin.RandomLine;
import com.roulette.core.bet.strategy.nowin.RandomOddEven;
import com.roulette.core.bet.strategy.nowin.RandomSplit;
import com.roulette.core.bet.strategy.nowin.RandomStreet;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.params.provider.Arguments.of;

public class RandomBetRouletteTest extends BaseRouletteTest {

    @ParameterizedTest
    @MethodSource(value = "randomBetTestCases")
    void shouldPlayRouletteWithRandomBet(BetStrategy<Factor> betStrategy) {
        for (int i = 0; i < ITERATIONS; i++) {
            play(roulette(betStrategy.getName()), betStrategy);
        }
    }

    private static Stream<Arguments> randomBetTestCases() {
        return Stream.of(
            of(new RandomColor(BET)),
            of(new RandomOddEven(BET)),
            of(new RandomHalf(BET)),
            of(new RandomDozen(BET)),
            of(new RandomColumn(BET)),
            of(new RandomSplit(BET)),
            of(new RandomField(BET)),   //TODO fix only 4 iterations
            of(new RandomStreet(BET)),
            of(new RandomCorner(BET)),
            of(new RandomLine(BET))
        );
    }
}
