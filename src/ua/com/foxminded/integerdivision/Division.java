package ua.com.foxminded.integerdivision;

import java.util.Objects;

/**
 * Date: Jan 23-2021 Class make integer division
 * without fractional part
 *
 * @author Aleksandr Serogin
 * @version 1.0001
 */
public class Division {

    private final StringBuilder result = new StringBuilder(); // final format string return  with result
    private final StringBuilder finalQuotient = new StringBuilder(); // write format quotient
    private final StringBuilder partiallyConstructedQuotient = new StringBuilder(); //  write format reminder

    /**
     * @param dividend in digits
     * @param divisor  in digits
     * @return formated string with integers division
     */
    public String makeDivision(Integer dividend, Integer divisor) {

        Objects.requireNonNull(divisor, "Divisor cannot be null");  // check on null
        Objects.requireNonNull(dividend, "Dividend cannot be null");  // check on null
        if (divisor == 0) {  // check on zero
            throw new IllegalArgumentException("Divisor cannot be 0, division by zero");
        }
        dividend = Math.abs(dividend); // bring to a positive value
        divisor = Math.abs(divisor); // bring to a positive value
        if (dividend < divisor) { // check  if true return massage
            return "" + dividend + "/" + divisor + "=0";
        }
        String[] digits = String.valueOf(dividend).split("");
        int finalReminder; // declared partially-constructed quotient
        int subtrahend; // declared subtracted value
        int divisorDigit = calculateDigit(divisor); // calculate long divisor
        Integer partiallyConstructedRemainder; // declared partially-constructed remainder

        for (int i = 0; i < digits.length; i++) {
            partiallyConstructedQuotient.append(digits[i]); // append current digit to the partiallyConstructedQuotient
            finalReminder = Integer.parseInt(partiallyConstructedQuotient.toString()); // get finalReminder
            if (finalReminder < divisor) { //append 0 if finalReminder < divisor
                if (i >= divisorDigit) {
                    finalQuotient.append(0);
                }
            } else {
                partiallyConstructedRemainder = finalReminder % divisor; //calculate partially-constructed remainder
                subtrahend = (finalReminder / divisor) * divisor; // calculate subtrahend
                // set the length of the string, convert all input in string
                String lastReminder = String.format("%" + (i + 2) + "s", "_" + Integer.toString(finalReminder));
                result.append(lastReminder).append("\n"); // set the beginning of a new line
                // set the length of the string, write only decimal integer
                String multiply = String.format("%" + (i + 2) + "d", subtrahend);
                result.append(multiply).append("\n"); // set the beginning of a new line
                Integer tab = lastReminder.length() - calculateDigit(subtrahend); // calculate number of tabs
                result.append(makeDivider(finalReminder, tab)).append("\n"); // set the beginning of a new line
                finalQuotient.append(finalReminder / divisor); //append quotient to final quotient string
                // replace with the remainder of the subtraction
                partiallyConstructedQuotient.replace(0, partiallyConstructedQuotient.length(), partiallyConstructedRemainder.toString());
                // write remainder in  finalReminder
                finalReminder = Integer.parseInt(partiallyConstructedQuotient.toString());
            }
            if (i == digits.length - 1) { // writing final reminder in end result string
                result.append(String.format("%" + (i + 2) + "s", Integer.toString(finalReminder))).append("\n");
            }
        }
        modifyResultToView(dividend, divisor); // celled function format string
        return result.toString(); // return format string
    }

    /**
     * @param numberDashes declared number of dashes
     * @param numberTabs declared number of tabs
     * @return
     */
    private String makeDivider(Integer numberDashes, Integer numberTabs) { // append in string tabs and dash
        return assemblyString(numberTabs, ' ') + assemblyString(calculateDigit(numberDashes), '-');
    }

    private void modifyResultToView(Integer dividend, Integer divisor) {
        int[] index = new int[3];
        for (int i = 0, j = 0; i < result.length(); i++) {
            if (result.charAt(i) == '\n') { //calculated index and of string
                index[j] = i; // write index in massive
                j++;
            }
            if (j == 3) { //break cycle after 3 passes
                break;
            }
        }
        int tabIndex1 = calculateDigit(dividend) + 1 - index[0]; //calculated number of tabs fo 1 string
        int tabIndex2 = calculateDigit(dividend) - 1 - calculateDigit(index[2]); //calculated number of tabs fo 2 string
        if (tabIndex2 <= 0) {
            tabIndex2 = tabIndex2 + 1;
        }
        //set the number of spaces, and subsequent signs and values
        result.insert(index[2], assemblyString(tabIndex2, ' ') + "│" + finalQuotient.toString());
        result.insert(index[1], assemblyString(tabIndex1, ' ') + "│" + assemblyString(finalQuotient.length(), '-'));
        result.insert(index[0], "│" + divisor);
        result.replace(1, index[0], dividend.toString());
    }

    /**
     * @param number input digit
     * @return number length
     */
    private int calculateDigit(int number) { // get number length
        return (int) Math.log10(number) + 1;
    }

    /**
     * @param numberOfSymbols get specified number
     * @param symbol get symbol
     * @return final string
     */
    // append characters to the string according to the specified number
    private String assemblyString(int numberOfSymbols, char symbol) {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < numberOfSymbols; i++) {
            string.append(symbol);
        }
        return string.toString();
    }
}