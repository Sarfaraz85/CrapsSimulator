package org.sarfaraz.craps;


import java.util.stream.IntStream;

public class Dice {
    private Die die1 = new Die();
    private Die die2 = new Die();


    public void thrown() {

        die1.roll();
        die2.roll();

//        IntStream.rangeClosed(1, 100)
//                .boxed()
//                .peek(i->die1.roll())
//                .peek(i->die2.roll())
//                .forEach(i -> System.out.println("" + die1.getLastRoll() + "," + die2.getLastRoll() + " - " + lastThrow()));

    }

    public int lastThrow(){
        return die1.getLastRoll() + die2.getLastRoll();
    }
    int firstDie(){
        return die1.getLastRoll();
    }
    int secondDie(){
        return die2.getLastRoll();
    }

//    public static void main(String[] args) {
//        Dice dice = new Dice();
//        dice.thrown();
//    }
}






























