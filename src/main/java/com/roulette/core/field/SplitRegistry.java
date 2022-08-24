package com.roulette.core.field;

import java.util.List;
import java.util.Random;

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

public class SplitRegistry {

    public static final Split S_1_2 = new Split(F_1, F_2);
    public static final Split S_1_4 = new Split(F_1, F_4);
    public static final Split S_2_3 = new Split(F_2, F_3);
    public static final Split S_2_5 = new Split(F_2, F_5);
    public static final Split S_3_6 = new Split(F_3, F_6);
    public static final Split S_4_5 = new Split(F_4, F_5);
    public static final Split S_4_7 = new Split(F_4, F_7);
    public static final Split S_5_6 = new Split(F_5, F_6);
    public static final Split S_5_8 = new Split(F_5, F_8);
    public static final Split S_6_9 = new Split(F_6, F_9);
    public static final Split S_7_8 = new Split(F_7, F_8);
    public static final Split S_7_10 = new Split(F_7, F_10);
    public static final Split S_8_9 = new Split(F_8, F_9);
    public static final Split S_8_11 = new Split(F_8, F_11);
    public static final Split S_9_12 = new Split(F_9, F_12);
    public static final Split S_10_11 = new Split(F_10, F_11);
    public static final Split S_10_13 = new Split(F_10, F_13);
    public static final Split S_11_12 = new Split(F_11, F_12);
    public static final Split S_11_14 = new Split(F_11, F_14);
    public static final Split S_12_15 = new Split(F_12, F_15);
    public static final Split S_13_14 = new Split(F_13, F_14);
    public static final Split S_13_16 = new Split(F_13, F_16);
    public static final Split S_14_15 = new Split(F_14, F_15);
    public static final Split S_14_17 = new Split(F_14, F_17);
    public static final Split S_15_18 = new Split(F_15, F_18);
    public static final Split S_16_17 = new Split(F_16, F_17);
    public static final Split S_16_19 = new Split(F_16, F_19);
    public static final Split S_17_18 = new Split(F_17, F_18);
    public static final Split S_17_20 = new Split(F_17, F_20);
    public static final Split S_18_21 = new Split(F_18, F_21);
    public static final Split S_19_20 = new Split(F_19, F_20);
    public static final Split S_19_22 = new Split(F_19, F_22);
    public static final Split S_20_21 = new Split(F_20, F_21);
    public static final Split S_20_23 = new Split(F_20, F_23);
    public static final Split S_21_24 = new Split(F_21, F_24);
    public static final Split S_22_23 = new Split(F_22, F_23);
    public static final Split S_22_25 = new Split(F_22, F_25);
    public static final Split S_23_24 = new Split(F_23, F_24);
    public static final Split S_23_26 = new Split(F_23, F_26);
    public static final Split S_24_27 = new Split(F_24, F_27);
    public static final Split S_25_26 = new Split(F_25, F_26);
    public static final Split S_25_28 = new Split(F_25, F_28);
    public static final Split S_26_27 = new Split(F_26, F_27);
    public static final Split S_26_29 = new Split(F_26, F_29);
    public static final Split S_27_30 = new Split(F_27, F_30);
    public static final Split S_28_29 = new Split(F_28, F_29);
    public static final Split S_28_31 = new Split(F_28, F_31);
    public static final Split S_29_30 = new Split(F_29, F_30);
    public static final Split S_29_32 = new Split(F_29, F_32);
    public static final Split S_30_33 = new Split(F_30, F_33);
    public static final Split S_31_32 = new Split(F_31, F_32);
    public static final Split S_31_34 = new Split(F_31, F_34);
    public static final Split S_32_33 = new Split(F_32, F_33);
    public static final Split S_32_35 = new Split(F_32, F_35);
    public static final Split S_33_36 = new Split(F_33, F_36);
    public static final Split S_34_35 = new Split(F_34, F_35);
    public static final Split S_35_36 = new Split(F_35, F_36);

    private static final Random RANDOM = new Random();

    public static Split random() {
        return SPLITS.get(RANDOM.nextInt(SPLITS.size()));
    }

    public static final List<Split> SPLITS = List.of(
        S_1_2,
        S_1_4,
        S_2_3,
        S_2_5,
        S_3_6,
        S_4_5,
        S_4_7,
        S_5_6,
        S_5_8,
        S_6_9,
        S_7_8,
        S_7_10,
        S_8_9,
        S_8_11,
        S_9_12,
        S_10_11,
        S_10_13,
        S_11_12,
        S_11_14,
        S_12_15,
        S_13_14,
        S_13_16,
        S_14_15,
        S_14_17,
        S_15_18,
        S_16_17,
        S_16_19,
        S_17_18,
        S_17_20,
        S_18_21,
        S_19_20,
        S_19_22,
        S_20_21,
        S_20_23,
        S_21_24,
        S_22_23,
        S_22_25,
        S_23_24,
        S_23_26,
        S_24_27,
        S_25_26,
        S_25_28,
        S_26_27,
        S_26_29,
        S_27_30,
        S_28_29,
        S_28_31,
        S_29_30,
        S_29_32,
        S_30_33,
        S_31_32,
        S_31_34,
        S_32_33,
        S_32_35,
        S_33_36,
        S_34_35,
        S_35_36
    );
}
