package ua.com.foxminded.division.math;

import ua.com.foxminded.division.exception.Validator;
import ua.com.foxminded.division.model.Result;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Date: Feb 01-2021 Class make integer division without
 * fractional string part
 *
 * @author Aleksandr Serogin
 * @version 1.0001
 */

public class Divider {

    private ArrayList<Integer> numbersTab;

    /**
     * @param dividend
     * @param divisor
     * @return Object class Result
     */
    public Result divide(Integer dividend, Integer divisor) {
        Validator validator = new Validator();
        validator.validateArguments(dividend, divisor); // check the validity of values
        int quotient = getQuotient(dividend, divisor);
        int remainder = getRemainder(dividend, divisor);
        int longChar = getLongChar(quotient);
        int longDividend = getLongDividend(dividend);
        int positiveDividend = getPositiveNumber(dividend);
        int positiveDivisor = getPositiveNumber(divisor);
        int positiveQuotient = getPositiveNumber(quotient);
        int positiveRemainder = getPositiveNumber(remainder);
        ArrayList<Integer> subtrahend = getSubtrahend(positiveQuotient, positiveDivisor);
        ArrayList<Integer> minuend = getMinuend(positiveDividend, positiveDivisor);
        ArrayList<Integer> numbersTab = getNumbersTab(dividend, divisor, minuend, longDividend);
        ArrayList<Integer> longMinued = getLongMinued(minuend);
        ArrayList<Integer> numbersTabMinesOne = getNumbersTabsMinesOne(numbersTab);
        int numbersCycle = getNumbersCycle(minuend);
        int numbersСycleMinesOne = getNumbersСycleMinesOne(numbersCycle);
        int tabOneForStringTwo = getTabOneForStringTwo(subtrahend, longDividend);
        int tabTwoForStringTwo = getTabTwoForStringTwo(subtrahend, dividend);
        int longLastTab = getLongLastTab(positiveRemainder, longDividend, longMinued, subtrahend, dividend, divisor);
        int tabTwoForStringThree = getTabTwoForStringThree(longChar, dividend, divisor);
        // saving calculation result
        Result results = new Result(dividend, divisor, quotient, remainder, longChar, subtrahend, minuend, numbersTab,
                numbersCycle, longMinued, longLastTab, numbersTabMinesOne, numbersСycleMinesOne,
                tabOneForStringTwo, tabTwoForStringTwo, tabTwoForStringThree);
        return results;
    }

    private Integer getPositiveNumber(int number) {
        return Math.abs(number);
    }

    /**
     * @param digits any numbers
     * @return ArrayList numbers
     */
    private ArrayList<Integer> numberDigit(Integer digits) {
        final int base = 10; //could be anything
        final ArrayList<Integer> result = new ArrayList<>();
        while (true) {
            if (digits == 0) break;
            result.add(digits % (base));
            digits = digits / base;
        }
        IntStream.range(0, result.size() / 2).forEach(i -> {
            int tmp = result.get(i);
            result.set(i, result.get(result.size() - i - 1));
            result.set(result.size() - i - 1, tmp);
        });
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
    private ArrayList<Integer> getSubtrahend(int quotient, int divisor) {
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
        ArrayList<Integer> minuend = new ArrayList<>();
        String[] digits = String.valueOf(dividend).split("");
        Integer finalReminder; // declared partially-constructed quotient
        int partiallyConstructedRemainder; // declared partially-constructed remainder

        for (int i = 0; i < digits.length; i++) {
            partiallyConstructedQuotient.append(digits[i]); // append current digit to the partiallyConstructedQuotient
            finalReminder = Integer.parseInt(partiallyConstructedQuotient.toString()); // get finalReminder
            if (finalReminder >= divisor) {
                minuend.add(finalReminder);
                partiallyConstructedRemainder = finalReminder % divisor;
                partiallyConstructedQuotient.replace(0, partiallyConstructedQuotient.length(),
                        Integer.toString(partiallyConstructedRemainder));

            }
        }
        return minuend;
    }

    /**
     * @param dividend
     * @param divisor
     * @param minuend
     * @return ArrayList numbers tab
     */
    private ArrayList<Integer> getNumbersTab(Integer dividend, Integer divisor, ArrayList<Integer> minuend, int longDividend) {
        final StringBuilder partiallyConstructedQuotient = new StringBuilder(); // write format reminder
        ArrayList<Integer> tabs = new ArrayList<>();
        String[] digits = String.valueOf(Math.abs(dividend)).split("");
        int finalReminder; // declared partially-constructed quotient
        int partiallyConstructedRemainder; // declared partially-constructed remainder
        int tab = 0;
        for (int i = 0, y = 0; i < digits.length; i++) {
            partiallyConstructedQuotient.append(digits[i]); // append current digit to the partiallyConstructedQuotient
            finalReminder = Integer.parseInt(partiallyConstructedQuotient.toString()); // get finalReminder
            if (finalReminder >= Math.abs(divisor)) { // append 0 if finalReminder < divisor
                partiallyConstructedRemainder = finalReminder % Math.abs(divisor);
                if (dividend < 0) {
                    if (y == 0) {
                        tab = (i + 2) - numberDigit(minuend.get(y)).size();
                        tabs.add(tab);

                    } else {
                        tab = (i + 3) - numberDigit(minuend.get(y)).size();
                        tabs.add(tab);

                    }
                } else {
                    tab = (i + 2) - numberDigit(minuend.get(y)).size();
                    tabs.add(tab);

                }
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
    private int getLongLastTab(Integer remainder, int longDividend, ArrayList<Integer> longMinued, ArrayList<Integer> subtrahend, int dividend, int divisor) {
        int longRemainder = numberDigit(remainder).size();
        int result = longDividend - longRemainder;
        int LongLastSubtrahend = numberDigit(subtrahend.get(subtrahend.size() - 1)).size();
        int LongLastMinued = longMinued.get(longMinued.size() - 1);
        if (LongLastSubtrahend <= LongLastMinued) {
            result += 1;
        }
        if (result > longDividend) {
            result -= 1;
        }
        if (dividend < 0 | divisor < 0) {
            result = (longDividend + 1 - longRemainder);
        }
        if (dividend > 0 & divisor < 0)
        {
            if (longRemainder == 0) {
                result = (longDividend + 1 - longRemainder) - 1;
            }
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
    private int getTabTwoForStringTwo(ArrayList<Integer> subtrahend, int dividend) {
        return numberDigit(subtrahend.get(0)).size() + 2;
    }

    /**
     * @param longChar
     * @return long char mines One
     */
    private int getTabTwoForStringThree(Integer longChar, int dividend, int divisor) {
        if (dividend < 0) {
            if (divisor < 0) {
                return longChar - 1;
            }
            return longChar - 2;
        }
        if (divisor < 0) {
            return longChar - 2;
        }
        return longChar - 1;
    }

    /**
     * @param quotient
     * @return number length
     */
    private int getLongChar(Integer quotient) {
        if (quotient < 0) {
            return numberDigit(quotient).size() + 1;
        }
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
}