package com.roulette.core;

import com.roulette.core.Field.Column;
import com.roulette.core.Field.Dozen;

import static com.roulette.core.Field.Color.BLACK;
import static com.roulette.core.Field.Color.GREEN;
import static com.roulette.core.Field.Color.RED;

public class FieldRegistry {
    public static final Field ZERO = new Field(0, GREEN, null, null);

    // First Dozen

    public static final Field RED_1 = new Field(1, RED, Dozen.D1, Column.C1);
    public static final Field BLACK_2 = new Field(2, BLACK, Dozen.D1, Column.C2);
    public static final Field RED_3 = new Field(3, RED, Dozen.D1, Column.C3);

    public static final Field BLACK_4 = new Field(4, BLACK, Dozen.D1, Column.C1);
    public static final Field RED_5 = new Field(5, RED, Dozen.D1, Column.C2);
    public static final Field BLACK_6 = new Field(6, BLACK, Dozen.D1, Column.C3);

    public static final Field RED_7 = new Field(7, RED, Dozen.D1, Column.C1);
    public static final Field BLACK_8 = new Field(8, BLACK, Dozen.D1, Column.C2);
    public static final Field RED_9 = new Field(9, RED, Dozen.D1, Column.C3);

    public static final Field BLACK_10 = new Field(10, BLACK, Dozen.D1, Column.C1);
    public static final Field BLACK_11 = new Field(11, BLACK, Dozen.D1, Column.C2);
    public static final Field RED_12 = new Field(12, RED, Dozen.D1, Column.C3);

    // Second Dozen

    public static final Field BLACK_13 = new Field(13, BLACK, Dozen.D2, Column.C1);
    public static final Field RED_14 = new Field(14, RED, Dozen.D2, Column.C2);
    public static final Field BLACK_15 = new Field(15, BLACK, Dozen.D2, Column.C3);

    public static final Field RED_16 = new Field(16, RED, Dozen.D2, Column.C1);
    public static final Field BLACK_17 = new Field(17, BLACK, Dozen.D2, Column.C2);
    public static final Field RED_18 = new Field(18, RED, Dozen.D2, Column.C3);

    public static final Field RED_19 = new Field(19, RED, Dozen.D2, Column.C1);
    public static final Field BLACK_20 = new Field(20, BLACK, Dozen.D2, Column.C2);
    public static final Field RED_21 = new Field(21, RED, Dozen.D2, Column.C3);

    public static final Field BLACK_22 = new Field(22, BLACK, Dozen.D2, Column.C1);
    public static final Field RED_23 = new Field(23, RED, Dozen.D2, Column.C2);
    public static final Field BLACK_24 = new Field(24, BLACK, Dozen.D2, Column.C3);

    // Third Dozen

    public static final Field RED_25 = new Field(25, RED, Dozen.D3, Column.C1);
    public static final Field BLACK_26 = new Field(26, BLACK, Dozen.D3, Column.C2);
    public static final Field RED_27 = new Field(27, RED, Dozen.D3, Column.C3);

    public static final Field BLACK_28 = new Field(28, BLACK, Dozen.D3, Column.C1);
    public static final Field BLACK_29 = new Field(29, BLACK, Dozen.D3, Column.C2);
    public static final Field RED_30 = new Field(30, RED, Dozen.D3, Column.C3);

    public static final Field BLACK_31 = new Field(31, BLACK, Dozen.D3, Column.C1);
    public static final Field RED_32 = new Field(32, RED, Dozen.D3, Column.C2);
    public static final Field BLACK_33 = new Field(33, BLACK, Dozen.D3, Column.C3);

    public static final Field RED_34 = new Field(34, RED, Dozen.D3, Column.C1);
    public static final Field BLACK_35 = new Field(35, BLACK, Dozen.D3, Column.C2);
    public static final Field RED_36 = new Field(36, RED, Dozen.D3, Column.C3);
}
