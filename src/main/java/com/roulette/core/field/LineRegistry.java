package com.roulette.core.field;

import java.util.List;
import java.util.Random;

import static com.roulette.core.field.FieldRegistry.*;

public class LineRegistry {

    public static final Line L_1_6 = new Line(F_1, F_2, F_3, F_4, F_5, F_6);
    public static final Line L_4_9 = new Line(F_4, F_5, F_6, F_7, F_8, F_9);
    public static final Line L_7_12 = new Line(F_7, F_8, F_9, F_10, F_11, F_12);
    public static final Line L_10_15 = new Line(F_10, F_11, F_12, F_13, F_14, F_15);
    public static final Line L_13_18 = new Line(F_13, F_14, F_15, F_16, F_17, F_18);
    public static final Line L_16_21 = new Line(F_16, F_17, F_18, F_19, F_20, F_21);
    public static final Line L_19_24 = new Line(F_19, F_20, F_21, F_22, F_23, F_24);
    public static final Line L_22_27 = new Line(F_22, F_23, F_24, F_25, F_26, F_27);
    public static final Line L_25_30 = new Line(F_25, F_26, F_27, F_28, F_29, F_30);
    public static final Line L_28_33 = new Line(F_28, F_29, F_30, F_31, F_32, F_33);
    public static final Line L_31_36 = new Line(F_31, F_32, F_33, F_34, F_35, F_36);

    public static final List<Line> LINES = List.of(
        L_1_6,
        L_4_9,
        L_7_12,
        L_10_15,
        L_13_18,
        L_16_21,
        L_19_24,
        L_22_27,
        L_25_30,
        L_28_33,
        L_31_36
    );

    private static final Random RANDOM = new Random();

    public static Line random() {
        return LINES.get(RANDOM.nextInt(LINES.size()));
    }
}
