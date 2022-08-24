package com.roulette.core;

import java.util.List;
import java.util.Random;

import com.roulette.core.field.Field;
import com.roulette.stats.Stats;

import static com.roulette.core.field.FieldRegistry.*;

public class RouletteWheel {

    private static final Random RANDOM = new Random();
    private static final List<Field> REEL = List.of(
        ZERO,
        F_32,
        F_15,
        F_19,
        F_4,
        F_21,
        F_2,
        F_25,
        F_17,
        F_34,
        F_6,
        F_27,
        F_13,
        F_36,
        F_11,
        F_30,
        F_8,
        F_23,
        F_10,
        F_5,
        F_24,
        F_16,
        F_33,
        F_1,
        F_20,
        F_14,
        F_31,
        F_9,
        F_22,
        F_18,
        F_29,
        F_7,
        F_28,
        F_12,
        F_35,
        F_3,
        F_26
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
