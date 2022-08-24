package com.roulette.core;

import java.util.Arrays;
import java.util.Random;

import lombok.Value;

import static com.roulette.core.FieldRegistry.ZERO;

@Value
public class Field {

    int number;
    Color color;
    Dozen dozen;
    Column column;

    public enum Color {
        RED, BLACK, GREEN;

        private static final Random RANDOM = new Random();

        public static Color random() {
            return Arrays.asList(values()).get(RANDOM.nextInt(2));  // exclude GREEN
        }
    }

    public enum Dozen {
        D1, D2, D3;
    }

    public enum Column {
        C1, C2, C3
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
        return String.format("%s %s", number, color);
    }
}
