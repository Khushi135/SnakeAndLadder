package org.example.models;

import java.util.Random;
import java.util.random.RandomGenerator;

public class Dice {
    private final int numberOfSides;
    Random random = new Random();

    public Dice(int numberOfSides) {
        this.numberOfSides = numberOfSides;
    }

    public int rollDice(){
        int randomNumber = random.nextInt(1,6);
        return randomNumber;
    }
}
