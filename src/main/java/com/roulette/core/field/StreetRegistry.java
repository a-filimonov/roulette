package com.roulette.core.field;

import java.util.List;
import java.util.Random;

import static com.roulette.core.field.FieldRegistry.*;

public class StreetRegistry {

    public static final Street S_0_1_2 = new Street(ZERO, F_1, F_2);
    public static final Street S_0_2_3 = new Street(ZERO, F_2, F_3);
    public static final Street S_1_2_3 = new Street(F_1, F_2, F_3);
    public static final Street S_4_5_6 = new Street(F_4, F_5, F_6);
    public static final Street S_7_8_9 = new Street(F_7, F_8, F_9);
    public static final Street S_10_11_12 = new Street(F_10, F_11, F_12);
    public static final Street S_13_14_15 = new Street(F_13, F_14, F_15);
    public static final Street S_16_17_18 = new Street(F_16, F_17, F_18);
    public static final Street S_19_20_21 = new Street(F_19, F_20, F_21);
    public static final Street S_22_23_24 = new Street(F_22, F_23, F_24);
    public static final Street S_25_26_27 = new Street(F_25, F_26, F_27);
    public static final Street S_28_29_30 = new Street(F_28, F_29, F_30);
    public static final Street S_31_32_33 = new Street(F_31, F_32, F_33);
    public static final Street S_34_35_36 = new Street(F_34, F_35, F_36);

    private static final Random RANDOM = new Random();

    public static Street random() {
        return STREETS.get(RANDOM.nextInt(STREETS.size()));
    }

    public static final List<Street> STREETS = List.of(
        S_0_1_2,
        S_0_2_3,
        S_1_2_3,
        S_4_5_6,
        S_7_8_9,
        S_10_11_12,
        S_13_14_15,
        S_16_17_18,
        S_19_20_21,
        S_22_23_24,
        S_25_26_27,
        S_28_29_30,
        S_31_32_33,
        S_34_35_36
    );
}
