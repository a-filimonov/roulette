package com.roulette.core;

import java.util.List;
import java.util.Random;

import com.roulette.stats.Stats;

import static com.roulette.core.FieldRegistry.*;

public class RouletteWheel {

    private static final Random RANDOM = new Random();
    private static final List<Field> REEL = List.of(
        ZERO,
        RED_32,
        BLACK_15,
        RED_19,
        BLACK_4,
        RED_21,
        BLACK_2,
        RED_25,
        BLACK_17,
        RED_34,
        BLACK_6,
        RED_27,
        BLACK_13,
        RED_36,
        BLACK_11,
        RED_30,
        BLACK_8,
        RED_23,
        BLACK_10,
        RED_5,
        BLACK_24,
        RED_16,
        BLACK_33,
        RED_1,
        BLACK_20,
        RED_14,
        BLACK_31,
        RED_9,
        BLACK_22,
        RED_18,
        BLACK_29,
        RED_7,
        BLACK_28,
        RED_12,
        BLACK_35,
        RED_3,
        BLACK_26
    );

    private final Stats.RouletteStats stats;

    public RouletteWheel(Stats.RouletteStats stats) {
        this.stats = stats;
    }

    public Field turn() {
        stats.addTurn();
        return REEL.get(RANDOM.nextInt(REEL.size()));
    }
}
