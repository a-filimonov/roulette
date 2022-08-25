package com.roulette.core.field;

import java.util.List;
import java.util.Random;

import com.roulette.core.field.Field.Column;
import com.roulette.core.field.Field.Dozen;

public class FieldRegistry {
    public static final Field ZERO = new Field(0, null, null, null);

    // First Dozen

    public static final Field F_1 = new Field(1, true, Dozen.D1, Column.C1);
    public static final Field F_2 = new Field(2, false, Dozen.D1, Column.C2);
    public static final Field F_3 = new Field(3, true, Dozen.D1, Column.C3);

    public static final Field F_4 = new Field(4, false, Dozen.D1, Column.C1);
    public static final Field F_5 = new Field(5, true, Dozen.D1, Column.C2);
    public static final Field F_6 = new Field(6, false, Dozen.D1, Column.C3);

    public static final Field F_7 = new Field(7, true, Dozen.D1, Column.C1);
    public static final Field F_8 = new Field(8, false, Dozen.D1, Column.C2);
    public static final Field F_9 = new Field(9, true, Dozen.D1, Column.C3);

    public static final Field F_10 = new Field(10, false, Dozen.D1, Column.C1);
    public static final Field F_11 = new Field(11, false, Dozen.D1, Column.C2);
    public static final Field F_12 = new Field(12, true, Dozen.D1, Column.C3);

    // Second Dozen

    public static final Field F_13 = new Field(13, false, Dozen.D2, Column.C1);
    public static final Field F_14 = new Field(14, true, Dozen.D2, Column.C2);
    public static final Field F_15 = new Field(15, false, Dozen.D2, Column.C3);

    public static final Field F_16 = new Field(16, true, Dozen.D2, Column.C1);
    public static final Field F_17 = new Field(17, false, Dozen.D2, Column.C2);
    public static final Field F_18 = new Field(18, true, Dozen.D2, Column.C3);

    public static final Field F_19 = new Field(19, true, Dozen.D2, Column.C1);
    public static final Field F_20 = new Field(20, false, Dozen.D2, Column.C2);
    public static final Field F_21 = new Field(21, true, Dozen.D2, Column.C3);

    public static final Field F_22 = new Field(22, false, Dozen.D2, Column.C1);
    public static final Field F_23 = new Field(23, true, Dozen.D2, Column.C2);
    public static final Field F_24 = new Field(24, false, Dozen.D2, Column.C3);

    // Third Dozen

    public static final Field F_25 = new Field(25, true, Dozen.D3, Column.C1);
    public static final Field F_26 = new Field(26, false, Dozen.D3, Column.C2);
    public static final Field F_27 = new Field(27, true, Dozen.D3, Column.C3);

    public static final Field F_28 = new Field(28, false, Dozen.D3, Column.C1);
    public static final Field F_29 = new Field(29, false, Dozen.D3, Column.C2);
    public static final Field F_30 = new Field(30, true, Dozen.D3, Column.C3);

    public static final Field F_31 = new Field(31, false, Dozen.D3, Column.C1);
    public static final Field F_32 = new Field(32, true, Dozen.D3, Column.C2);
    public static final Field F_33 = new Field(33, false, Dozen.D3, Column.C3);

    public static final Field F_34 = new Field(34, true, Dozen.D3, Column.C1);
    public static final Field F_35 = new Field(35, false, Dozen.D3, Column.C2);
    public static final Field F_36 = new Field(36, true, Dozen.D3, Column.C3);

    public static final List<Field> FIELDS = List.of(
        F_1,
        F_2,
        F_3,
        F_4,
        F_5,
        F_6,
        F_7,
        F_8,
        F_9,
        F_10,
        F_11,
        F_12,
        F_13,
        F_14,
        F_15,
        F_16,
        F_17,
        F_18,
        F_19,
        F_20,
        F_21,
        F_22,
        F_23,
        F_24,
        F_25,
        F_26,
        F_27,
        F_28,
        F_29,
        F_30,
        F_31,
        F_32,
        F_33,
        F_34,
        F_35,
        F_36
    );

    private static final Random RANDOM = new Random();

    public static Field random() {
        return FIELDS.get(RANDOM.nextInt(FIELDS.size()));
    }

}
