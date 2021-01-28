package ua.com.foxminded.division.math;

import ua.com.foxminded.division.model.Result;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Date: Jan 23-2021 Class make integer division without fractional part
 *
 * @author Aleksandr Serogin
 * @version 1.0001
 */

public class Divider {

    public Result divide(Integer dividend, Integer divisor) {
        validateArguments(dividend, divisor);
        Integer quotient = dividend / divisor;
        Integer remainder = dividend % divisor;
        int longDivisor = numberDigit(divisor).size();
        int longChar = numberDigit(quotient).size();
        ArrayList<Integer> subtrahend = getSubtrahend(quotient, divisor);
        ArrayList<Integer> minuend = getMinuend(dividend, divisor, subtrahend);
        ArrayList<Integer> numbersTabs = getNumbersTabs(dividend, divisor, subtrahend);
        int numbersCickle = minuend.size();

        Result results = new Result(dividend, divisor, quotient, remainder, longChar, subtrahend, minuend, numbersTabs, numbersCickle, longDivisor);
        return results;
    }

    private void validateArguments(Integer dividend, Integer divisor) {
        Objects.requireNonNull(divisor, "Divisor cannot be null"); // check on null
        Objects.requireNonNull(dividend, "Dividend cannot be null"); // check on null
        if (divisor == 0) {
            throw new IllegalArgumentException("Divider is zero. Can't division by zero");
        }
        if (dividend < divisor) {
            throw new IllegalArgumentException("Dividend is lower them divider");
        }
        if (divisor < 0) {
            throw new IllegalArgumentException("Divider is below zero");
        }
    }

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

    private ArrayList<Integer> getSubtrahend(int quotient, Integer divisor) {

        ArrayList<Integer> subtrahend = new ArrayList<>();
        ArrayList<Integer> numbersQuotient = numberDigit(quotient);
        for (int i = 0; i < numbersQuotient.size(); i++) {
            if (numbersQuotient.get(i) > 0) {
                subtrahend.add(divisor * numbersQuotient.get(i));
            }
        }
        return subtrahend;
    }

    private ArrayList<Integer> getMinuend(Integer dividend, Integer divisor, ArrayList<Integer> subtrahends) {

        final StringBuilder partiallyConstructedQuotient = new StringBuilder(); // write format reminder
        ArrayList<Integer> Minuend = new ArrayList<>();
        String[] digits = String.valueOf(dividend).split("");
        Integer finalReminder; // declared partially-constructed quotient
        Integer partiallyConstructedRemainder; // declared partially-constructed remainder

        for (int i = 0, y = 0; i < digits.length; i++) {
            partiallyConstructedQuotient.append(digits[i]); // append current digit to the partiallyConstructedQuotient
            finalReminder = Integer.parseInt(partiallyConstructedQuotient.toString()); // get finalReminder
            if (finalReminder < divisor) { // append 0 if finalReminder < divisor
            } else {
                Minuend.add(finalReminder);
                partiallyConstructedRemainder = finalReminder % divisor;
                partiallyConstructedQuotient.replace(0, partiallyConstructedQuotient.length(),
                        partiallyConstructedRemainder.toString());
                y++;
            }
        }
        return Minuend;
    }

    private ArrayList<Integer> getNumbersTabs(Integer dividend, Integer divisor, ArrayList<Integer> subtrahends) {

        final StringBuilder partiallyConstructedQuotient = new StringBuilder(); // write format reminder
        ArrayList<Integer> tabs = new ArrayList<>();
        String[] digits = String.valueOf(dividend).split("");
        Integer finalReminder; // declared partially-constructed quotient
        Integer partiallyConstructedRemainder; // declared partially-constructed remainder
        Integer tab = 0;
        for (int i = 0, y = 0; i < digits.length; i++) {
            partiallyConstructedQuotient.append(digits[i]); // append current digit to the partiallyConstructedQuotient
            finalReminder = Integer.parseInt(partiallyConstructedQuotient.toString()); // get finalReminder
            if (finalReminder < divisor) { // append 0 if finalReminder < divisor
            } else {
                partiallyConstructedRemainder = finalReminder % divisor;
                tab = (i + 2) - numberDigit(subtrahends.get(y)).size();
                tabs.add(tab);
                partiallyConstructedQuotient.replace(0, partiallyConstructedQuotient.length(),
                        partiallyConstructedRemainder.toString());
                y++;
            }
        }
        return tabs;
    }
}
