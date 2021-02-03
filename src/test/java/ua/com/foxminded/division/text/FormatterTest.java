package ua.com.foxminded.division.text;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ua.com.foxminded.division.model.Result;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FormatterTest {

    private static Result resultMock;
    private static Formatter formatter;

    @BeforeEach
    public void setUp() {
        resultMock = Mockito.mock(Result.class);
        formatter = new Formatter();
    }

    @Test
    public void shouldFormatString() {

        final int dividend = 78945;
        final int divisor = 4;
        final int quotient = 19736;
        final int remainder = 1;
        final int longChar = 5;
        final List<Integer> subtrahend = new ArrayList<>();
        final List<Integer> minuend = new ArrayList<>();
        final List<Integer> numbersTab = new ArrayList<>();
        final int numbersCycle = 5;
        final List<Integer> longMinued = new ArrayList<>();
        final int longLastTab = 5;
        final List<Integer> numbersTabMinesOne = new ArrayList<>();
        final int numbersCycleMinesOne = 4;
        final int tabOneForStringTwo = 4;
        final int tabTwoForStringTwo = 3;
        final int longCharMinesOne = 4;

        subtrahend.add(4);
        subtrahend.add(36);
        subtrahend.add(28);
        subtrahend.add(12);
        subtrahend.add(24);
        minuend.add(7);
        minuend.add(38);
        minuend.add(29);
        minuend.add(14);
        minuend.add(25);
        numbersTab.add(1);
        numbersTab.add(1);
        numbersTab.add(2);
        numbersTab.add(3);
        numbersTab.add(4);
        longMinued.add(1);
        longMinued.add(2);
        longMinued.add(2);
        longMinued.add(2);
        longMinued.add(2);
        numbersTabMinesOne.add(0);
        numbersTabMinesOne.add(0);
        numbersTabMinesOne.add(1);
        numbersTabMinesOne.add(2);
        numbersTabMinesOne.add(3);

        Mockito.when(resultMock.getDividend()).thenReturn(dividend);
        Mockito.when(resultMock.getDivisor()).thenReturn(divisor);
        Mockito.when(resultMock.getQuotient()).thenReturn(quotient);
        Mockito.when(resultMock.getRemainder()).thenReturn(remainder);
        Mockito.when(resultMock.getLongChar()).thenReturn(longChar);
        Mockito.when(resultMock.getSubtrahend()).thenReturn(subtrahend);
        Mockito.when(resultMock.getMinuend()).thenReturn(minuend);
        Mockito.when(resultMock.getNumbersTab()).thenReturn(numbersTab);
        Mockito.when(resultMock.getNumbersCycle()).thenReturn(numbersCycle);
        Mockito.when(resultMock.getLongMinued()).thenReturn(longMinued);
        Mockito.when(resultMock.getLongLastTab()).thenReturn(longLastTab);
        Mockito.when(resultMock.getNumbersTabMinesOne()).thenReturn(numbersTabMinesOne);
        Mockito.when(resultMock.getTabOneForStringTwo()).thenReturn(tabOneForStringTwo);
        Mockito.when(resultMock.getTabTwoForStringTwo()).thenReturn(tabTwoForStringTwo);
        Mockito.when(resultMock.getlongCharMinesOne()).thenReturn(longCharMinesOne);
        Mockito.when(resultMock.getNumbersСycleMinesOne()).thenReturn(numbersCycleMinesOne);

        String expected = "_78945│4\n" +
                " 4    │-----\n" +
                " -    │19736\n" +
                "_38\n" +
                " 36\n" +
                " --\n" +
                " _29\n" +
                "  28\n" +
                "  --\n" +
                "  _14\n" +
                "   12\n" +
                "   --\n" +
                "   _25\n" +
                "    24\n" +
                "    --\n" +
                "     1\n";
        assertEquals(expected, formatter.format(resultMock));
    }
}

