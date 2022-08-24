package com.roulette.core.field;

import java.util.List;
import java.util.Random;

import static com.roulette.core.field.FieldRegistry.*;

public class CornerRegistry {

    public static final Corner C_0_1_2_3 = new Corner(ZERO, F_1, F_2, F_3);
    public static final Corner C_1_2_4_5 = new Corner(F_1, F_2, F_4, F_5);
    public static final Corner C_2_3_5_6 = new Corner(F_2, F_3, F_5, F_6);
    public static final Corner C_4_5_7_8 = new Corner(F_4, F_5, F_7, F_8);
    public static final Corner C_5_6_8_9 = new Corner(F_5, F_6, F_8, F_9);
    public static final Corner C_7_8_10_11 = new Corner(F_7, F_8, F_10, F_11);
    public static final Corner C_8_9_11_12 = new Corner(F_8, F_9, F_11, F_12);
    public static final Corner C_10_11_13_14 = new Corner(F_10, F_11, F_13, F_14);
    public static final Corner C_11_12_14_15 = new Corner(F_11, F_12, F_14, F_15);
    public static final Corner C_13_14_16_17 = new Corner(F_13, F_14, F_16, F_17);
    public static final Corner C_14_15_17_18 = new Corner(F_14, F_15, F_17, F_18);
    public static final Corner C_16_17_19_20 = new Corner(F_16, F_17, F_19, F_20);
    public static final Corner C_17_18_20_21 = new Corner(F_17, F_18, F_20, F_21);
    public static final Corner C_19_20_22_23 = new Corner(F_19, F_20, F_22, F_23);
    public static final Corner C_20_21_23_24 = new Corner(F_20, F_21, F_23, F_24);
    public static final Corner C_22_23_25_26 = new Corner(F_22, F_23, F_25, F_26);
    public static final Corner C_23_24_26_27 = new Corner(F_23, F_24, F_26, F_27);
    public static final Corner C_25_26_28_29 = new Corner(F_25, F_26, F_28, F_29);
    public static final Corner C_26_27_29_30 = new Corner(F_26, F_27, F_29, F_30);
    public static final Corner C_28_29_31_32 = new Corner(F_28, F_29, F_31, F_32);
    public static final Corner C_29_30_32_33 = new Corner(F_29, F_30, F_32, F_33);
    public static final Corner C_31_32_34_35 = new Corner(F_31, F_32, F_34, F_35);
    public static final Corner C_32_33_35_36 = new Corner(F_32, F_33, F_35, F_36);

    private static final Random RANDOM = new Random();

    public static Corner random() {
        return CORNERS.get(RANDOM.nextInt(CORNERS.size()));
    }

    public static final List<Corner> CORNERS = List.of(
        C_0_1_2_3,
        C_1_2_4_5,
        C_2_3_5_6,
        C_4_5_7_8,
        C_5_6_8_9,
        C_7_8_10_11,
        C_8_9_11_12,
        C_10_11_13_14,
        C_11_12_14_15,
        C_13_14_16_17,
        C_14_15_17_18,
        C_16_17_19_20,
        C_17_18_20_21,
        C_19_20_22_23,
        C_20_21_23_24,
        C_22_23_25_26,
        C_23_24_26_27,
        C_25_26_28_29,
        C_26_27_29_30,
        C_28_29_31_32,
        C_29_30_32_33,
        C_31_32_34_35,
        C_32_33_35_36
    );
}
