package com.roulette;

import java.util.Arrays;
import java.util.Random;

import lombok.Value;

@Value
public class Field {

    int number;
    Color color;

    public enum Color {
        RED, BLACK, GREEN;

        private static final Random RANDOM = new Random();

        public static Color random() {
            return Arrays.asList(values()).get(RANDOM.nextInt(2));  // exclude GREEN
        }
    }

    public String toString() {
        return String.format("%s %s", number, color);
    }
}
