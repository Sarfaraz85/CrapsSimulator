package org.sarfaraz.craps.bets;

import org.sarfaraz.craps.BetType;

import static java.util.Arrays.asList;
import static org.sarfaraz.craps.BetType.*;

public class PassLineBet extends Bet{

    public PassLineBet(double amount) {
        setAmount(amount);
        setBetType(PASS_LINE);
        setOneRollBet(false);
        setPayoutMultiplier(1);
        setLosingNumbers(asList(7));
    }
    public void setPoint(int point){
        setWinningNumbers(asList(point));
    }
}
