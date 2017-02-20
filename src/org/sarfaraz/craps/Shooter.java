package org.sarfaraz.craps;

import java.util.HashMap;

public class Shooter {
    int id;
    String name;
    int bankroll;
    int totalShootTurns;
    int longestRoll;
    int numSevenOuts;
    int numPointSevenOut;
    HashMap<Integer, TurnRoll> turnRoll;

    public Shooter(int num) {
        name = "Shooter" + num;
        id = num;
        turnRoll = new HashMap<>();
        turnRoll.put(1, new TurnRoll());
    }
}
