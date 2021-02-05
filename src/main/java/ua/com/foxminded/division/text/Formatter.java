package ua.com.foxminded.division.text;

import ua.com.foxminded.division.model.Result;

import java.util.List;
/**
 * Date: Feb 01-2021 Class make format string
 *
 * @author Aleksandr Serogin
 * @version 1.0001
 */

/**
 * format string with given values
 */
public class Formatter {

    /**
     * @param result input object class Result
     * @return format string
     */
    public String format(Result result) {

        final int dividend = result.getDividend();
        final int divisor = result.getDivisor();
        final int quotient = result.getQuotient();
        final int remainder = result.getRemainder();
        final int longChar = result.getLongChar();
        final int longLastTab = result.getLongLastTab();
        final int tabOneForStringTwo = result.getTabOneForStringTwo();
        final int tabTwoForStringTwo = result.getTabTwoForStringTwo();
        final int numbersCycle = result.getNumbersCycle();
        final int tabTwoForStringThree = result.getTabTwoForStringThree();
        final int numbersCycleMinesOne = result.getNumbersСycleMinesOne();
        final List<Integer> subtrahend = result.getSubtrahend();
        final List<Integer> numbersTabsMinesOne = result.getNumbersTabMinesOne();
        final List<Integer> minuend = result.getMinuend();
        final List<Integer> numbersTab = result.getNumbersTab();
        final List<Integer> longMinued = result.getLongMinued();
        final StringBuilder finalString = new StringBuilder();
        // string formatting with given values
        for (int i = 0; i < numbersCycle; i++) {
            String multiply;
            String lastReminder = String.format("%s", assemblyString(numbersTabsMinesOne.get(i), ' ') + "_" + minuend.get(i));
            finalString.append(lastReminder).append("\n");
            if (i == 0) {
                multiply = String.format("%s", assemblyString(numbersTabsMinesOne.get(i), ' ') + subtrahend.get(i));
            } else {
                multiply = String.format("%s", assemblyString(numbersTab.get(i), ' ') + subtrahend.get(i));
            }
            finalString.append(multiply).append("\n");
            if (dividend < 0 & i == 0) {
                finalString.append(" ");
            }
            finalString.append(makeDivider(longMinued.get(i), numbersTab.get(i))).append("\n");
            if (i == numbersCycleMinesOne) {
                finalString.append(String.format("%s", assemblyString(longLastTab, ' ') + remainder)).append("\n");
            }
        }
        modifyResultToView(dividend, divisor, quotient, longChar, finalString, tabOneForStringTwo,
                tabTwoForStringTwo, tabTwoForStringThree); // celled function format string
        return finalString.toString(); // return format string
    }

    /**
     * @param numbersDashes numbers dashes
     * @param numbersTabs   numbers tabs
     * @return format string
     */
    private String makeDivider(Integer numbersDashes, Integer numbersTabs) { // append in string tabs and dash
        return assemblyString(numbersTabs, ' ') + assemblyString(numbersDashes, '-');
    }

    // format first tree lines
    private void modifyResultToView(Integer dividend, Integer divisor, Integer quotient, int longChar,
                                    StringBuilder finalString, int tabOneForStringTwo, int tabTwoForStringTwo,
                                    int tabTwoForStringThree) {
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
        finalString.insert(index[2], assemblyString(tabTwoForStringThree, ' ') + "│" + quotient.toString());
        finalString.insert(index[1], assemblyString(tabOneForStringTwo, ' ') + "│" + assemblyString(longChar, '-'));
        if (dividend < 0) {
            finalString.insert(tabTwoForStringTwo, assemblyString(2, ' '));
        } else {
            finalString.insert(tabTwoForStringTwo, ' ');
        }
        finalString.insert(index[0], "│" + divisor);
        finalString.replace(1, index[0], dividend.toString());
    }

    /**
     * @param numbersOfSymbols numbers of symbols
     * @param symbol
     * @return format string
     */
    private String assemblyString(int numbersOfSymbols, char symbol) {
        StringBuilder string = new StringBuilder();
        string.append(String.valueOf(symbol).repeat(Math.max(0, numbersOfSymbols)));
        return string.toString();
    }
}