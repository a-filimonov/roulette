package com.roulette.core;

import java.util.List;
import java.util.Random;

import com.roulette.core.field.Field;

import static com.roulette.core.field.FieldRegistry.F_1;
import static com.roulette.core.field.FieldRegistry.F_10;
import static com.roulette.core.field.FieldRegistry.F_11;
import static com.roulette.core.field.FieldRegistry.F_12;
import static com.roulette.core.field.FieldRegistry.F_13;
import static com.roulette.core.field.FieldRegistry.F_14;
import static com.roulette.core.field.FieldRegistry.F_15;
import static com.roulette.core.field.FieldRegistry.F_16;
import static com.roulette.core.field.FieldRegistry.F_17;
import static com.roulette.core.field.FieldRegistry.F_18;
import static com.roulette.core.field.FieldRegistry.F_19;
import static com.roulette.core.field.FieldRegistry.F_2;
import static com.roulette.core.field.FieldRegistry.F_20;
import static com.roulette.core.field.FieldRegistry.F_21;
import static com.roulette.core.field.FieldRegistry.F_22;
import static com.roulette.core.field.FieldRegistry.F_23;
import static com.roulette.core.field.FieldRegistry.F_24;
import static com.roulette.core.field.FieldRegistry.F_25;
import static com.roulette.core.field.FieldRegistry.F_26;
import static com.roulette.core.field.FieldRegistry.F_27;
import static com.roulette.core.field.FieldRegistry.F_28;
import static com.roulette.core.field.FieldRegistry.F_29;
import static com.roulette.core.field.FieldRegistry.F_3;
import static com.roulette.core.field.FieldRegistry.F_30;
import static com.roulette.core.field.FieldRegistry.F_31;
import static com.roulette.core.field.FieldRegistry.F_32;
import static com.roulette.core.field.FieldRegistry.F_33;
import static com.roulette.core.field.FieldRegistry.F_34;
import static com.roulette.core.field.FieldRegistry.F_35;
import static com.roulette.core.field.FieldRegistry.F_36;
import static com.roulette.core.field.FieldRegistry.F_4;
import static com.roulette.core.field.FieldRegistry.F_5;
import static com.roulette.core.field.FieldRegistry.F_6;
import static com.roulette.core.field.FieldRegistry.F_7;
import static com.roulette.core.field.FieldRegistry.F_8;
import static com.roulette.core.field.FieldRegistry.F_9;
import static com.roulette.core.field.FieldRegistry.ZERO;

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

    public Field turn() {
        return REEL.get(RANDOM.nextInt(REEL.size()));
    }
}
