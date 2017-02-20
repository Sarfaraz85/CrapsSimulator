package org.sarfaraz.craps.bets;

import org.sarfaraz.craps.BetType;

import java.util.ArrayList;
import java.util.List;

public abstract class Bet {
    BetType betType;
    double amount;
    double payoutMultiplier;
    boolean oneRollBet;
    List<Integer> winningNumbers = new ArrayList<>();
    List<Integer> losingNumbers = new ArrayList<>();

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public BetType getBetType() {
        return betType;
    }

    public void setBetType(BetType betType) {
        this.betType = betType;
    }

    public List<Integer> getLosingNumbers() {
        return losingNumbers;
    }

    public void setLosingNumbers(List<Integer> losingNumbers) {
        this.losingNumbers = losingNumbers;
    }

    public boolean isOneRollBet() {
        return oneRollBet;
    }

    public void setOneRollBet(boolean oneRollBet) {
        this.oneRollBet = oneRollBet;
    }

    public double getPayoutMultiplier() {
        return payoutMultiplier;
    }

    public void setPayoutMultiplier(double payoutMultiplier) {
        this.payoutMultiplier = payoutMultiplier;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public void setWinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }
}
