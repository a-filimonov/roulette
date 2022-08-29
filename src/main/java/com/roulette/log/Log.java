package com.roulette.log;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Log {

    private final boolean debug;

    public void info(String str, Object... args) {
        System.out.printf(str, args);
    }

    public void infoln(String str, Object... args) {
        System.out.printf((str) + "%n", args);
    }

    public void debug(String str, Object... args) {
        if (debug) {
            info(str, args);
        }
    }

    public void debugln(String str, Object... args) {
        if (debug) {
            infoln(str, args);
        }
    }
}
