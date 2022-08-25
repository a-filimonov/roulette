package com.roulette.core.field;

import com.roulette.core.bet.Factor;
import lombok.Value;

@Value
public class Line implements Factor {
    Field f1;
    Field f2;
    Field f3;
    Field f4;
    Field f5;
    Field f6;
}
