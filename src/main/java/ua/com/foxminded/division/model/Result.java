package ua.com.foxminded.division.model;

import java.util.ArrayList;

public class Result {

    private final int dividend;
    private final int divisor;
    private final int quotient;
    private final int remainder;
    private final int longChar;
    private final ArrayList<Integer> subtrahend;
    private final ArrayList<Integer> minuend;
    private final ArrayList<Integer> numbersTabs;
    private final int numbersCickle;
    private final int longDivisor;

    public Result(
            final int dividend,
            final int divisor,
            final int quotient,
            final int remainder,
            final int longChar,
            final ArrayList<Integer> subtrahend,
            final ArrayList<Integer> minuend,
            final ArrayList<Integer> numbersTabs,
            final int numbersCickle,
            final int longDivisor)
    {
        this.dividend = dividend;
        this.divisor = divisor;
        this.quotient = quotient;
        this.remainder = remainder;
        this.longChar = longChar;
        this.subtrahend = subtrahend;
        this.minuend = minuend;
        this.numbersTabs = numbersTabs;
        this.numbersCickle = numbersCickle;
        this.longDivisor = longDivisor;
    }


    public int getDividend() {
        return dividend;
    }

    public int getDivisor() {
        return divisor;
    }

    public int getQuotient() {
        return quotient;
    }

    public int getRemainder() {
        return remainder;
    }

    public int getLongChar() {
        return longChar;
    }

    public ArrayList<Integer> getSubtrahend() {
        return subtrahend;
    }
    public ArrayList<Integer> getMinuend() {
        return minuend;
    }

    public ArrayList<Integer> getNumbersTabs() {
        return numbersTabs;
    }
    public int getNumbersCickle() {

        return numbersCickle;
    }

    public int getLongDivisor() {

        return longDivisor;
    }

}
