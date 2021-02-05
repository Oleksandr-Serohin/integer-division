package ua.com.foxminded.division.exception;

import java.util.Objects;

/**
 * Date: Feb 01-2021 Checks input numbers
 * if validation fails prints a message
 *
 * @author Aleksandr Serogin
 * @version 1.0001
 */

public class Validator {

    /**
     * @param dividend number for check
     * @param divisor  number for check
     */
    public void validateArguments(Integer dividend, Integer divisor) {
        Objects.requireNonNull (divisor, "Divisor cannot be null"); // check on null
        Objects.requireNonNull (dividend, "Dividend cannot be null"); // check on null
        dividend = Math.abs (dividend);
        divisor = Math.abs (divisor);
        if (divisor == 0) {
            throw new IllegalArgumentException ("Divider is zero. Can't division by zero");
        }
        if (dividend < divisor) {
            throw new IllegalArgumentException ("Divisor cannot be greater than dividend.");
        }
    }

    /**
     * @param arg  string for check
     * @param arg1 string for check
     */
    public void argumentLargeExceptions(String arg, String arg1) { //checking can wi put string in int
        try {
            Integer dividend = Integer.valueOf (arg);
        } catch (RuntimeException e) {
            throw new RuntimeException ("You can to enter max ten digits in one value.");
        }
        try {
            Integer divisor = Integer.valueOf (arg1);
        } catch (RuntimeException e) {
            throw new RuntimeException ("You can to enter max ten digits in one value.");
        }
    }
}
