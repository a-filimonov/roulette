package com.roulette;

import java.util.Arrays;
import java.util.Random;

import lombok.Value;

@Value
public class Field {

    public static final Field ZERO = new Field(0, Color.GREEN);

    int number;
    Color color;

    public enum Color {
        RED, BLACK, GREEN;

        private static final Random RANDOM = new Random();

        public static Color random() {
            return Arrays.asList(values()).get(RANDOM.nextInt(2));  // exclude GREEN
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
        return String.format("%s %s", number, color);
    }
}
