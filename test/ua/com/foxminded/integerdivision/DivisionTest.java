package ua.com.foxminded.integerdivision;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ua.com.foxminded.integerdivision.Division;

import static org.junit.jupiter.api.Assertions.*;

public class DivisionTest {
    Division division;

    @BeforeEach
    public void setUp()
    {
        division = new Division();
    }

    @Test
    public void shouldMakeDivision() {
        String expected = "_14789│20\n" +
                " 140  │---\n" +
                " ---  │739\n" +
                "  _78\n" +
                "   60\n" +
                "   --\n" +
                "  _189\n" +
                "   180\n" +
                "   ---\n" +
                "     9\n";
        assertEquals(expected, division.makeDivision(14789, 20));
    }

    @Test
    public void When_Dividendnull_Expect_NullPointerException() {
        Integer isNull = null;
        NullPointerException thrown = assertThrows( NullPointerException.class, () -> division.makeDivision(isNull, 12));
        assertEquals("Dividend cannot be null", thrown.getMessage());
    }
    
    @Test
    public void When_Divisornull_Expect_NullPointerException() {
        Integer isNull = null;
        NullPointerException thrown = assertThrows( NullPointerException.class, () -> division.makeDivision(12, isNull));
        assertEquals("Divisor cannot be null", thrown.getMessage());  
    }

    @Test
    public void When_Divisor0_Expect_ExceptionWithSuperType() {
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> division.makeDivision(42, 0));
    assertEquals("Divisor cannot be 0, division by zero", thrown.getMessage());
    }

    @Test
    public void When_DivisorLargeDividend_Expect_ErrorMassege() {
        String expected = "512/555=0";
        assertEquals(expected, division.makeDivision(512, 555));
    }

}
