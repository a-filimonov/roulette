package com.roulette.core;

import java.util.List;
import java.util.Random;

import com.roulette.core.Field.Column;
import com.roulette.core.Field.Dozen;

import static com.roulette.core.Field.Color.BLACK;
import static com.roulette.core.Field.Color.GREEN;
import static com.roulette.core.Field.Color.RED;

public class FieldRegistry {
    public static final Field ZERO = new Field(0, GREEN, null, null);

    // First Dozen

    public static final Field F_1 = new Field(1, RED, Dozen.D1, Column.C1);
    public static final Field F_2 = new Field(2, BLACK, Dozen.D1, Column.C2);
    public static final Field F_3 = new Field(3, RED, Dozen.D1, Column.C3);

    public static final Field F_4 = new Field(4, BLACK, Dozen.D1, Column.C1);
    public static final Field F_5 = new Field(5, RED, Dozen.D1, Column.C2);
    public static final Field F_6 = new Field(6, BLACK, Dozen.D1, Column.C3);

    public static final Field F_7 = new Field(7, RED, Dozen.D1, Column.C1);
    public static final Field F_8 = new Field(8, BLACK, Dozen.D1, Column.C2);
    public static final Field F_9 = new Field(9, RED, Dozen.D1, Column.C3);

    public static final Field F_10 = new Field(10, BLACK, Dozen.D1, Column.C1);
    public static final Field F_11 = new Field(11, BLACK, Dozen.D1, Column.C2);
    public static final Field F_12 = new Field(12, RED, Dozen.D1, Column.C3);

    // Second Dozen

    public static final Field F_13 = new Field(13, BLACK, Dozen.D2, Column.C1);
    public static final Field F_14 = new Field(14, RED, Dozen.D2, Column.C2);
    public static final Field F_15 = new Field(15, BLACK, Dozen.D2, Column.C3);

    public static final Field F_16 = new Field(16, RED, Dozen.D2, Column.C1);
    public static final Field F_17 = new Field(17, BLACK, Dozen.D2, Column.C2);
    public static final Field F_18 = new Field(18, RED, Dozen.D2, Column.C3);

    public static final Field F_19 = new Field(19, RED, Dozen.D2, Column.C1);
    public static final Field F_20 = new Field(20, BLACK, Dozen.D2, Column.C2);
    public static final Field F_21 = new Field(21, RED, Dozen.D2, Column.C3);

    public static final Field F_22 = new Field(22, BLACK, Dozen.D2, Column.C1);
    public static final Field F_23 = new Field(23, RED, Dozen.D2, Column.C2);
    public static final Field F_24 = new Field(24, BLACK, Dozen.D2, Column.C3);

    // Third Dozen

    public static final Field F_25 = new Field(25, RED, Dozen.D3, Column.C1);
    public static final Field F_26 = new Field(26, BLACK, Dozen.D3, Column.C2);
    public static final Field F_27 = new Field(27, RED, Dozen.D3, Column.C3);

    public static final Field F_28 = new Field(28, BLACK, Dozen.D3, Column.C1);
    public static final Field F_29 = new Field(29, BLACK, Dozen.D3, Column.C2);
    public static final Field F_30 = new Field(30, RED, Dozen.D3, Column.C3);

    public static final Field F_31 = new Field(31, BLACK, Dozen.D3, Column.C1);
    public static final Field F_32 = new Field(32, RED, Dozen.D3, Column.C2);
    public static final Field F_33 = new Field(33, BLACK, Dozen.D3, Column.C3);

    public static final Field F_34 = new Field(34, RED, Dozen.D3, Column.C1);
    public static final Field F_35 = new Field(35, BLACK, Dozen.D3, Column.C2);
    public static final Field F_36 = new Field(36, RED, Dozen.D3, Column.C3);

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
