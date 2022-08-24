package com.roulette.util;

import java.util.Random;

public class BooleanUtil {

    private static final Random RANDOM = new Random();

    public static boolean flipCoin() {
        return RANDOM.nextBoolean();
    }
}
