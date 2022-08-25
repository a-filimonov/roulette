package com.roulette.util;

import java.util.Random;

import com.roulette.core.bet.Factor;
import lombok.Value;

@Value
public class Boolean implements Factor {

    public static final Boolean TRUE = new Boolean(true);
    public static final Boolean FALSE = new Boolean(false);
    private static final Random RANDOM = new Random();

    boolean value;
    
    public boolean isTrue() {
        return value;
    }
    
    public boolean isFalse() {
        return !value;
    }

    public static Boolean random() {
        return RANDOM.nextBoolean() ? TRUE : FALSE;
    }
}
