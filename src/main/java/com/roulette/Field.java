package com.roulette;

import java.util.Arrays;
import java.util.Random;
import java.util.Set;

import com.roulette.bet.ColumnBet;
import com.roulette.bet.DozenBet;
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

    public boolean isDozen(DozenBet.Dozen dozen) {
        switch (dozen) {
            case FIRST:
                return number >= 1 && number <= 12;
            case SECOND:
                return number >= 13 && number <= 24;
            case THIRD:
                return number >= 25 && number <= 36;
            default:
                throw new RuntimeException("Dozen unsupported: " + dozen);
        }
    }

    public boolean isInColumn(ColumnBet.Column column) {
        switch (column) {
            case FIRST:
                return Set.of(1, 4, 7, 10, 13, 16, 19, 22, 25, 28, 31, 34).contains(number);
            case SECOND:
                return Set.of(2, 5, 8, 11, 14, 17, 20, 23, 26, 29, 32, 35).contains(number);
            case THIRD:
                return Set.of(3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33, 36).contains(number);
            default:
                throw new RuntimeException("Column unsupported: " + column);
        }
    }

    public String toString() {
        return String.format("%s %s", number, color);
    }
}
