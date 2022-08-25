package com.roulette.core.field;

import java.util.Arrays;
import java.util.Random;

import lombok.Value;

import static com.roulette.core.field.FieldRegistry.ZERO;

@Value
public class Field {

    int number;
    Boolean red;    // null == ZERO
    Dozen dozen;
    Column column;

    public enum Dozen {
        D1, D2, D3;

        private static final Random RANDOM = new Random();

        public static Dozen random() {
            return Arrays.asList(values()).get(RANDOM.nextInt(values().length));
        }
    }

    public enum Column {
        C1, C2, C3;

        private static final Random RANDOM = new Random();

        public static Column random() {
            return Arrays.asList(values()).get(RANDOM.nextInt(values().length));
        }
    }

    public boolean isZero() {
        return this.equals(ZERO);
    }

    public boolean isEven() {
        return number % 2 == 0;
    }

    public boolean isFirstHalf() {
        return number >= 1 && number <= 18;
    }

    public String toString() {
        return String.format("%02d %s", number, red == null ? "ZERO" : red ? "RED" : "BLK");
    }
}
