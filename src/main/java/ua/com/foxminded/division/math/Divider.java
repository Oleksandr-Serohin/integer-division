package ua.com.foxminded.division.math;

import ua.com.foxminded.division.exception.Exception;
import ua.com.foxminded.division.model.Result;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Date: Feb 01-2021 Class make integer division without
 * fractional string part
 *
 * @author Aleksandr Serogin
 * @version 1.0001
 */

public class Divider {

    /**
     * @param dividend
     * @param divisor
     * @return Object class Result
     */
    public Result divide(Integer dividend, Integer divisor) {
        Exception exception = new Exception();
        exception.validateArguments(dividend, divisor); // check the validity of values
        int quotient = getQuotient(dividend, divisor);
        int remainder = getRemainder(dividend, divisor);
        int longChar = getLongChar(quotient);
        int longDividend = getLongDividend(dividend);
        ArrayList<Integer> subtrahend = getSubtrahend(quotient, divisor);
        ArrayList<Integer> minuend = getMinuend(dividend, divisor);
        ArrayList<Integer> numbersTab = getNumbersTab(dividend, divisor, subtrahend);
        ArrayList<Integer> longMinued = getLongMinued(minuend);
        ArrayList<Integer> numbersTabMinesOne = getNumbersTabsMinesOne(numbersTab);
        int numbersCycle = getNumbersCycle(minuend);
        int numbersСycleMinesOne = getNumbersСycleMinesOne(numbersCycle);
        int tabOneForStringTwo = getTabOneForStringTwo(subtrahend, longDividend);
        int tabTwoForStringTwo = getTabTwoForStringTwo(subtrahend);
        int longLastTab = getLongLastTab(remainder, longDividend, longMinued, subtrahend);
        int longCharMinesOne = getlongCharMinesOne(longChar);
        // saving calculation result
        Result results = new Result(dividend, divisor, quotient, remainder, longChar, subtrahend, minuend, numbersTab,
                numbersCycle, longMinued, longLastTab, numbersTabMinesOne, numbersСycleMinesOne,
                tabOneForStringTwo, tabTwoForStringTwo, longCharMinesOne);
        return results;
    }

    /**
     * @param digits any numbers
     * @return ArrayList numbers
     */
    private ArrayList<Integer> numberDigit(Integer digits) {
        final int base = 10; //could be anything
        final ArrayList<Integer> result = new ArrayList<>();
        while (digits != 0) {
            result.add(digits % (base));
            digits = digits / base;
        }
        for (int i = 0; i < result.size() / 2; i++) {
            int tmp = result.get(i);
            result.set(i, result.get(result.size() - i - 1));
            result.set(result.size() - i - 1, tmp);
        }
        return result;
    }

    /**
     * @param numbersTab numbers tabs
     * @return numbers tabs minus one
     */
    private ArrayList<Integer> getNumbersTabsMinesOne(ArrayList<Integer> numbersTab) {
        ArrayList<Integer> result;
        result = numbersTab.stream().map(integer -> integer - 1).collect(Collectors.toCollection(ArrayList::new));
        return result;
    }

    /**
     * @param minuend
     * @return long minuend
     */
    private ArrayList<Integer> getLongMinued(ArrayList<Integer> minuend) {
        final ArrayList<Integer> result = new ArrayList<>();
        for (Integer integer : minuend) {
            int longMinued = (numberDigit(integer)).size();
            result.add(longMinued);
        }
        return result;
    }

    /**
     * @param quotient
     * @param divisor
     * @return ArrayList subtrahend
     */
    private ArrayList<Integer> getSubtrahend(int quotient, Integer divisor) {
        ArrayList<Integer> subtrahend = new ArrayList<>();
        ArrayList<Integer> numbersQuotient = numberDigit(quotient);
        for (Integer integer : numbersQuotient) {
            if (integer > 0) {
                subtrahend.add(divisor * integer);
            }
        }
        return subtrahend;
    }

    /**
     * @param dividend
     * @param divisor
     * @return ArrayList minuend
     */
    private ArrayList<Integer> getMinuend(Integer dividend, Integer divisor) {
        final StringBuilder partiallyConstructedQuotient = new StringBuilder(); // write format reminder
        ArrayList<Integer> Minuend = new ArrayList<>();
        String[] digits = String.valueOf(dividend).split("");
        Integer finalReminder; // declared partially-constructed quotient
        int partiallyConstructedRemainder; // declared partially-constructed remainder

        for (int i = 0; i < digits.length; i++) {
            partiallyConstructedQuotient.append(digits[i]); // append current digit to the partiallyConstructedQuotient
            finalReminder = Integer.parseInt(partiallyConstructedQuotient.toString()); // get finalReminder
            if (finalReminder >= divisor) {
                Minuend.add(finalReminder);
                partiallyConstructedRemainder = finalReminder % divisor;
                partiallyConstructedQuotient.replace(0, partiallyConstructedQuotient.length(),
                        Integer.toString(partiallyConstructedRemainder));

            }
        }
        return Minuend;
    }

    /**
     * @param dividend
     * @param divisor
     * @param subtrahends
     * @return ArrayList numbers tab
     */
    private ArrayList<Integer> getNumbersTab(Integer dividend, Integer divisor, ArrayList<Integer> subtrahends) {
        final StringBuilder partiallyConstructedQuotient = new StringBuilder(); // write format reminder
        ArrayList<Integer> tabs = new ArrayList<>();
        String[] digits = String.valueOf(dividend).split("");
        int finalReminder; // declared partially-constructed quotient
        int partiallyConstructedRemainder; // declared partially-constructed remainder
        int tab = 0;
        for (int i = 0, y = 0; i < digits.length; i++) {
            partiallyConstructedQuotient.append(digits[i]); // append current digit to the partiallyConstructedQuotient
            finalReminder = Integer.parseInt(partiallyConstructedQuotient.toString()); // get finalReminder
            if (finalReminder >= divisor) { // append 0 if finalReminder < divisor
                partiallyConstructedRemainder = finalReminder % divisor;
                tab = (i + 2) - numberDigit(subtrahends.get(y)).size();
                tabs.add(tab);
                partiallyConstructedQuotient.replace(0, partiallyConstructedQuotient.length(),
                        Integer.toString(partiallyConstructedRemainder));
                y++;
            }
        }
        return tabs;
    }

    /**
     * @param remainder
     * @param longDividend
     * @param longMinued
     * @param subtrahend
     * @return long last tab
     */
    private int getLongLastTab(Integer remainder, int longDividend, ArrayList<Integer> longMinued, ArrayList<Integer> subtrahend) {
        int longRemainder = numberDigit(remainder).size();
        int result = longDividend - longRemainder;
        int LongLastSubstrahend = numberDigit(subtrahend.get(subtrahend.size() - 1)).size();
        int LongLastMinued = longMinued.get(longMinued.size() - 1);
        if (LongLastSubstrahend <= LongLastMinued) {
            result += 1;
        }
        if (result > longDividend) {
            result -= 1;
        }
        return result;
    }

    /**
     * @param minuend
     * @param longDividend
     * @return tab for format string
     */
    private int getTabOneForStringTwo(ArrayList<Integer> minuend, int longDividend) {
        return longDividend - numberDigit(minuend.get(0)).size();
    }

    /**
     * @param subtrahend
     * @return tab for format string
     */
    private int getTabTwoForStringTwo(ArrayList<Integer> subtrahend) {
        return numberDigit(subtrahend.get(0)).size() + 2;
    }

    /**
     * @param quotient
     * @return number length
     */
    private int getLongChar(Integer quotient) {
        return numberDigit(quotient).size();
    }

    /**
     * @param dividend
     * @return number length
     */
    private int getLongDividend(Integer dividend) {
        return numberDigit(dividend).size();
    }

    /**
     * @param dividend
     * @param divisor
     * @return quotient
     */
    private int getQuotient(Integer dividend, Integer divisor) {
        return dividend / divisor;
    }

    /**
     * @param dividend
     * @param divisor
     * @return remainder
     */
    private int getRemainder(Integer dividend, Integer divisor) {
        return dividend % divisor;
    }

    /**
     * @param minuend
     * @return numbers cycle
     */
    private int getNumbersCycle(ArrayList<Integer> minuend) {
        return minuend.size();
    }

    /**
     * @param numbersСycle
     * @return numbers cycle mines one
     */
    private int getNumbersСycleMinesOne(Integer numbersСycle) {
        return (int) (numbersСycle.longValue() - 1);
    }

    /**
     * @param longChar
     * @return long char mines One
     */
    private int getlongCharMinesOne(Integer longChar) {
        return longChar - 1;
    }
}