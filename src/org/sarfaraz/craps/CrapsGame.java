package org.sarfaraz.craps;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

import static org.sarfaraz.craps.Puck.OFF;
import static org.sarfaraz.craps.Puck.ON;

public class CrapsGame {

    private Dice dice = new Dice();
    int point;
    //    int numPointMade;
//    int numSevenOut;
//    int numNaturals;
//    int numCraps;
    Puck puck = OFF;
    Queue<Shooter> shooters = new LinkedList<>();

    public CrapsGame(int numShooters) {
        System.out.println("===== Starting new game =====");
        shooters = new LinkedList<>();
        IntStream.rangeClosed(1, numShooters)
                .forEach(i -> shooters.add(new Shooter(i)));
    }


    public static void main(String[] args) {
        CrapsGame game = new CrapsGame(2);
        IntStream.range(0, 50).boxed()
//                .filter(i -> game.numSevenOut < 10)
                .map(i -> game.passDiceToShooter())
                .forEach(game::diceThrowBy);
//        System.out.println("Points made : " + game.numPointMade);
//        System.out.println("Seven outs  : " + game.numSevenOut);
//        System.out.println("Natural 7/11: " + game.numNaturals);
//        System.out.println("Crap outs   : " + game.numCraps);


    }

    private Shooter passDiceToShooter() {

        return shooters.element();
//        return shooters.stream().filter(s -> s.isShooting).findFirst().orElse(shooters.element());
    }

    public void diceThrowBy(Shooter shooter) {
        if (puck == OFF)
            System.out.println("Come out roll...");
        else
            System.out.println("Shooting for point " + point);
        dice.thrown();
        evaluateDiceResult(shooter);
        //pay bets
    }

    public void evaluateDiceResult(Shooter shooter) {
        if (puck == OFF)
            comeOutRoll(shooter);
        else {
            if (dice.lastThrow() == point) pointMade();
            else if (dice.lastThrow() == 7) sevenOut();
            else {
                System.out.println("Shooter shoot " + dice.lastThrow());

            }
        }
    }

    private void pointMade() {
        point = 0;
        puck = OFF;
        System.out.println(dice.lastThrow() + " winner. Pass line wins.");
    }

    private void sevenOut() {
        point = 0;
        puck = OFF;
        System.out.println("Seven OUT!!!");
    }

    private void comeOutRoll(Shooter shooter) {
        TurnRoll turnRoll = shooter.turnRoll.get(shooter.totalShootTurns + 1);
        turnRoll.rolls.add(dice.lastThrow());
        if (dice.lastThrow() == 7 || dice.lastThrow() == 11) {  //naturals
            point = 0;
            puck = OFF;
            turnRoll.numNaturals += 1;
            if (dice.lastThrow() == 11)
                turnRoll.numField += 1;
            System.out.println(dice.lastThrow() + " Natural. Pass line winner.");
        } else if (dice.lastThrow() == 2 || dice.lastThrow() == 3 || dice.lastThrow() == 12) { //craps
            point = 0;
            puck = OFF;
            turnRoll.numCrapsOut += 1;
            if (dice.lastThrow() == 12) {
                turnRoll.numCrapsOut12 += 1;
                System.out.println(dice.lastThrow() + " Craps. Pass line loses. Don't pass pushed.");
            }
            else
                System.out.println(dice.lastThrow() + " Craps. Pass line loses.");
        } else { // point set
            point = dice.lastThrow();
            puck = ON;
            switch (dice.lastThrow()){
                case 4:
                    turnRoll.num4 += 1;
                    if(dice.firstDie()==dice.secondDie())
                        turnRoll.numHard4 += 1;
                    turnRoll.numField+=1;
            }
            System.out.println("Point is - " + point);
        }
    }

}
