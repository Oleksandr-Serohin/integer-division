package ua.com.foxminded.division.exception;

import java.util.Objects;

public class Validator {
    public void validateArguments(Integer dividend, Integer divisor) {
        Objects.requireNonNull(divisor, "Divisor cannot be null"); // check on null
        Objects.requireNonNull(dividend, "Dividend cannot be null"); // check on null
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        if (divisor == 0) {
            throw new IllegalArgumentException("Divider is zero. Can't division by zero");
        }
        if (dividend < divisor) {
            throw new IllegalArgumentException("Divisor cannot be greater than dividend.");
        }
    }
}
