package com.roulette.log;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Log {

    private final boolean debug;

    public void debug(String str, Object... args) {
        if (debug) {
            System.out.printf(str, args);
        }
    }

    public void debugln(String str, Object... args) {
        if (debug) {
            System.out.printf((str) + "%n", args);
        }
    }
}
