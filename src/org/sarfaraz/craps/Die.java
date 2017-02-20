package org.sarfaraz.craps;

import java.util.Random;

public class Die {

    private Random random = new Random();
    private int lastRoll;

    public int roll() {
        return lastRoll = random.nextInt(6) + 1;
    }

    public int getLastRoll() {
        return lastRoll;
    }
}
