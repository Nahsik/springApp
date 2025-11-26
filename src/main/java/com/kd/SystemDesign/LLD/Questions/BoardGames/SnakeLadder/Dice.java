package com.kd.SystemDesign.LLD.Questions.BoardGames.SnakeLadder;

import java.util.Random;

public class Dice {
    public static int throwDice() {
        Random random = new Random();
        return random.nextInt(1, 6);
    }
}
