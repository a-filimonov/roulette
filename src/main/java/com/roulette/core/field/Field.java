package com.roulette.core.field;

import java.util.List;
import java.util.Random;

import com.roulette.core.bet.Factor;
import lombok.Value;

import static com.roulette.core.field.FieldRegistry.ZERO;

@Value
public class Field implements Factor {

    int number;
    Boolean red;    // null == ZERO
    Dozen dozen;
    Column column;

    public enum Dozen implements Factor {
        D1, D2, D3;

        private static final Random RANDOM = new Random();

        public static Dozen random() {
            return List.of(values()).get(RANDOM.nextInt(values().length));
        }
    }

    public enum Column implements Factor {
        C1, C2, C3;

        private static final Random RANDOM = new Random();

        public static Column random() {
            return List.of(values()).get(RANDOM.nextInt(values().length));
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
