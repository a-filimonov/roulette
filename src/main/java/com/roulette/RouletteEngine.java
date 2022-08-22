package com.roulette;

import java.util.List;
import java.util.Random;

import lombok.Getter;
import lombok.NoArgsConstructor;

import static com.roulette.Field.Color.BLACK;
import static com.roulette.Field.Color.RED;

@NoArgsConstructor
public class RouletteEngine {

    private static final Random RANDOM = new Random();
    private static final List<Field> REEL = List.of(
        Field.ZERO,
        new Field(32, RED),
        new Field(15, BLACK),
        new Field(19, RED),
        new Field(4, BLACK),
        new Field(21, RED),
        new Field(2, BLACK),
        new Field(25, RED),
        new Field(17, BLACK),
        new Field(34, RED),
        new Field(6, BLACK),
        new Field(27, RED),
        new Field(13, BLACK),
        new Field(36, RED),
        new Field(11, BLACK),
        new Field(30, RED),
        new Field(8, BLACK),
        new Field(23, RED),
        new Field(10, BLACK),
        new Field(5, RED),
        new Field(24, BLACK),
        new Field(16, RED),
        new Field(33, BLACK),
        new Field(1, RED),
        new Field(20, BLACK),
        new Field(14, RED),
        new Field(31, BLACK),
        new Field(9, RED),
        new Field(22, BLACK),
        new Field(18, RED),
        new Field(29, BLACK),
        new Field(7, RED),
        new Field(28, BLACK),
        new Field(12, RED),
        new Field(35, BLACK),
        new Field(3, RED),
        new Field(26, BLACK)
    );

    @Getter
    private int turns;

    public Field turn() {
        turns++;
        return REEL.get(RANDOM.nextInt(REEL.size()));
    }
}
