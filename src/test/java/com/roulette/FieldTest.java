package com.roulette;

import java.util.ArrayList;
import java.util.List;

import com.roulette.core.Field;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FieldTest {

    @Test
    void shouldReturnRandomColorFromRedToBlack() {
        List<Field.Color> colors = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            colors.add(Field.Color.random());
        }

        assertTrue(colors.containsAll(List.of(Field.Color.RED, Field.Color.BLACK)));
        assertFalse(colors.contains(Field.Color.GREEN));
    }
}