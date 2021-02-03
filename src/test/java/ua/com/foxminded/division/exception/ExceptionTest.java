package ua.com.foxminded.division.exception;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.com.foxminded.division.math.Divider;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExceptionTest {

    Divider divider;

    @BeforeEach
    public void setUp()
    {
        divider = new Divider();;
    }

    @Test
    public void When_Dividendnull_Expect_NullPointerException() {
        Integer isNull = null;
        NullPointerException thrown = assertThrows( NullPointerException.class, () -> divider.divide(isNull, 12));
        assertEquals("Dividend cannot be null", thrown.getMessage());
    }

    @Test
    public void When_Divisornull_Expect_NullPointerException() {
        Integer isNull = null;
        NullPointerException thrown = assertThrows( NullPointerException.class, () -> divider.divide(12, isNull));
        assertEquals("Divisor cannot be null", thrown.getMessage());
    }

    @Test
    public void When_Divisor0_Expect_ExceptionWithSuperType() {
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> divider.divide(42, 0));
        assertEquals("Divider is zero. Can't division by zero", thrown.getMessage());
    }

    @Test
    public void When_DivisorLargesThenDividend_Expect_ExceptionWithSuperType() {
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> divider.divide(12, 122));
        assertEquals("Divisor cannot be greater than dividend.", thrown.getMessage());
    }
}
