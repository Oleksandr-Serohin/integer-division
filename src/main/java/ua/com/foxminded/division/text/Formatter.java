package ua.com.foxminded.division.text;

import ua.com.foxminded.division.model.Result;

import java.util.ArrayList;

public class Formatter {

    final StringBuilder finalString = new StringBuilder(); // final format string return with result

    public String format(Result result) {

        final int dividend = result.getDividend();
        final int divisor = result.getDivisor();
        final int quotient = result.getQuotient();
        final int remainder = result.getRemainder();
        final int longChar = result.getLongChar();
        final int longDivisor = result.getLongDivisor();
        final Integer numbersCickle = result.getNumbersCickle();
        final ArrayList<Integer> subtrahend = result.getSubtrahend();
        final ArrayList<Integer> finalReminder = result.getMinuend();
        final ArrayList<Integer> numbersTabs = result.getNumbersTabs();
        int tempLens3String = 0;
        for (int i = 0; i < numbersCickle; i++) {
            String multiply;
            tempLens3String = (int) (numbersTabs.get(i) + finalReminder.get(i).longValue());

            String lastReminder = String.format("%s", assemblyString(numbersTabs.get(i) - 1, ' ') + "_" + finalReminder.get(i));
            finalString.append(lastReminder).append("\n");
            if (i == 0) {
                multiply = String.format("%s", assemblyString(numbersTabs.get(i) - 1, ' ') + subtrahend.get(i));
            } else {
                multiply = String.format("%s", assemblyString(numbersTabs.get(i), ' ') + subtrahend.get(i));
            }
            finalString.append(multiply).append("\n");
            finalString.append(makeDivider(finalReminder.get(i), numbersTabs.get(i))).append("\n");
            if (i == numbersCickle.longValue() - 1) {
                finalString.append(String.format("%s", assemblyString(numbersTabs.get(i), ' ') + remainder)).append("\n");
            }
        }
        modifyResultToView(dividend, divisor, quotient, longChar, longDivisor); // celled function format string
        return finalString.toString(); // return format string
    }

    /**
     * @param numberDashes declared number of dashes
     * @param numberTabs   declared number of tabs
     * @return
     */
    private String makeDivider(Integer numberDashes, Integer numberTabs) { // append in string tabs and dash
        return assemblyString(numberTabs, ' ') + assemblyString(calculateDigit(numberDashes), '-');
    }

    /**
     * @param dividend value
     * @param divisor  value
     * @param longChar
     */
    private void modifyResultToView(Integer dividend, Integer divisor, Integer quotient, int longChar, int longDivisor) {
        int[] index = new int[3];
        for (int i = 0, j = 0; i < finalString.length(); i++) {
            if (finalString.charAt(i) == '\n') { // calculated index and of string
                index[j] = i; // write index in massive
                j++;
            }
            if (j == 3) { // break cycle after 3 writer in massive
                break;
            }
        }
        int tabIndex1 = calculateDigit(dividend) + 1 - index[0]; // calculated number of tabs for 1 string
        finalString.insert(index[2], assemblyString(longChar - 1, ' ') + "│" + quotient.toString());
        finalString.insert(index[1], assemblyString(tabIndex1, ' ') + "│" + assemblyString(longChar, '-'));
        finalString.insert((index[1] - longDivisor), ' ');
        finalString.insert(index[0], "│" + divisor);
        finalString.replace(1, index[0], dividend.toString());
    }

    private int calculateDigit(int number) { // get number length
        return (int) Math.log10(number) + 1;
    }

    private String assemblyString(int numberOfSymbols, char symbol) {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < numberOfSymbols; i++) {
            string.append(symbol);
        }
        return string.toString();
    }
}