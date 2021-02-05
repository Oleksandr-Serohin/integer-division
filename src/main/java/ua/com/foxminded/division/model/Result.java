package ua.com.foxminded.division.model;

import java.util.List;
/**
 * Date: Feb 01-2021 Class stores the calculated numbers
 *
 * @author Aleksandr Serogin
 * @version 1.0001
 */

/**
 * saving incoming values and return them
 */
public class Result {

    private final int dividend;
    private final int divisor;
    private final int quotient;
    private final int remainder;
    private final int longChar;
    private final List<Integer> subtrahend;
    private final List<Integer> minuend;
    private final List<Integer> numbersTab;
    private final int numbersCycle;
    private final List<Integer> longMinued;
    private final int longLastTab;
    private final List<Integer> numbersTabsMinesOne;
    private final int numbersСycleMinesOne;
    private final int tabOneForStringTwo;
    private final int tabTwoForStringTwo;
    private final int tabTwoForStringThree;

    public Result(
            final int dividend,
            final int divisor,
            final int quotient,
            final int remainder,
            final int longChar,
            final List<Integer> subtrahend,
            final List<Integer> minuend,
            final List<Integer> numbersTab,
            final int numbersСycle,
            final List<Integer> longMinued,
            final int longLastTab,
            final List<Integer> numbersTabsMinesOne,
            final int numbersСyclesMinesOne,
            final int tabOneForStringTwo,
            final int tabTwoForStringTwo,
            final int tabTwoForStringThree) {
        this.dividend = dividend;
        this.divisor = divisor;
        this.quotient = quotient;
        this.remainder = remainder;
        this.longChar = longChar;
        this.subtrahend = subtrahend;
        this.minuend = minuend;
        this.numbersTab = numbersTab;
        this.numbersCycle = numbersСycle;
        this.longMinued = longMinued;
        this.longLastTab = longLastTab;
        this.numbersTabsMinesOne = numbersTabsMinesOne;
        this.numbersСycleMinesOne = numbersСyclesMinesOne;
        this.tabOneForStringTwo = tabOneForStringTwo;
        this.tabTwoForStringTwo = tabTwoForStringTwo;
        this.tabTwoForStringThree = tabTwoForStringThree;
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

    public List<Integer> getSubtrahend() {
        return subtrahend;
    }

    public List<Integer> getMinuend() {
        return minuend;
    }

    public List<Integer> getNumbersTab() {
        return numbersTab;
    }

    public int getNumbersCycle() {
        return numbersCycle;
    }

    public List<Integer> getLongMinued() {
        return longMinued;
    }

    public int getLongLastTab() {
        return longLastTab;
    }

    public List<Integer> getNumbersTabMinesOne() {
        return numbersTabsMinesOne;
    }

    public int getNumbersСycleMinesOne() {
        return numbersСycleMinesOne;
    }

    public int getTabOneForStringTwo() {
        return tabOneForStringTwo;
    }

    public int getTabTwoForStringTwo() {
        return tabTwoForStringTwo;
    }

    public int getTabTwoForStringThree() {
        return tabTwoForStringThree;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Result)) return false;

        Result result = (Result) o;

        if (dividend != result.dividend) return false;
        if (divisor != result.divisor) return false;
        if (quotient != result.quotient) return false;
        if (remainder != result.remainder) return false;
        if (longChar != result.longChar) return false;
        if (numbersCycle != result.numbersCycle) return false;
        if (longLastTab != result.longLastTab) return false;
        if (numbersСycleMinesOne != result.numbersСycleMinesOne) return false;
        if (tabOneForStringTwo != result.tabOneForStringTwo) return false;
        if (tabTwoForStringTwo != result.tabTwoForStringTwo) return false;
        if (tabTwoForStringThree != result.tabTwoForStringThree) return false;
        if (subtrahend != null ? !subtrahend.equals(result.subtrahend) : result.subtrahend != null) return false;
        if (minuend != null ? !minuend.equals(result.minuend) : result.minuend != null) return false;
        if (numbersTab != null ? !numbersTab.equals(result.numbersTab) : result.numbersTab != null) return false;
        if (longMinued != null ? !longMinued.equals(result.longMinued) : result.longMinued != null) return false;
        return numbersTabsMinesOne != null ? numbersTabsMinesOne.equals(result.numbersTabsMinesOne) : result.numbersTabsMinesOne == null;
    }
}