package com.roulette.core.field;

import com.roulette.core.bet.Factor;
import lombok.Value;

@Value
public class Split implements Factor {
    Field f1;
    Field f2;
}
