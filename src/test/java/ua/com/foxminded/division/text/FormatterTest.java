package ua.com.foxminded.division.text;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ua.com.foxminded.division.math.Divider;
import ua.com.foxminded.division.model.Result;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FormatterTest {
    private static Divider divider;
    private static Result resultMock;
    private static Formatter formatter;

    @BeforeEach
    public void setUp() {
        formatter = new Formatter();
        divider = new Divider();
    }

    @Test
    public void shouldFormatString_WithPositiveNumbersVar1() {
        resultMock = Mockito.mock(Result.class);
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
        final int tabTwoForStringThree = 4;

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
        Mockito.when(resultMock.getTabTwoForStringThree()).thenReturn(tabTwoForStringThree);
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

    @Test
    public void shouldFormatString_WithPositiveNumbersVar2() {
        Result result = divider.divide(630440, 610);
        String output = formatter.format(result);

        String expected = """
                _630440│610
                 610   │----
                 ---   │1033
                 _2044
                  1830
                  ----
                  _2140
                   1830
                   ----
                    310
                """;
        assertEquals(expected, output);
    }

    @Test
    public void shouldFormatString_WithPositiveNumbersVar3() {
        Result result = divider.divide(12341234, 1234);
        String output = formatter.format(result);
        String expected = """
                _12341234│1234
                 1234    │-----
                 ----    │10001
                    _1234
                     1234
                     ----
                        0
                """;
        assertEquals(expected, output);
    }

    @Test
    public void shouldFormatString_WithPositiveNumbersVar4() {
        Result result = divider.divide(593593593, 593);
        String output = formatter.format(result);
        String expected = """
                _593593593│593
                 593      │-------
                 ---      │1001001
                   _593
                    593
                    ---
                      _593
                       593
                       ---
                         0
                """;
        assertEquals(expected, output);
    }

    @Test
    public void shouldFormatString_WithPositiveNumbersVar5() {
        Result result = divider.divide(12351234, 1234);
        String output = formatter.format(result);
        String expected = """
                _12351234│1234
                 1234    │-----
                 ----    │10009
                   _11234
                    11106
                    -----
                      128
                """;
        assertEquals(expected, output);
    }

    @Test
    public void shouldFormatString_WithPositiveNumbersVar6() {
        Result result = divider.divide(12341233, 1234);
        String output = formatter.format(result);
        String expected = """
                _12341233│1234
                 1234    │-----
                 ----    │10000
                     1233
                """;
        assertEquals(expected, output);
    }

    @Test
    public void shouldFormatString_WithPositiveNumbersVar7() {
        Result result = divider.divide(12353574, 1234);
        String output = formatter.format(result);
        String expected = """
                _12353574│1234
                 1234    │-----
                 ----    │10011
                   _1357
                    1234
                    ----
                    _1234
                     1234
                     ----
                        0
                """;
        assertEquals(expected, output);
    }

    @Test
    public void shouldFormatString_WithPositiveNumbersVar8() {
        Result result = divider.divide(12350000, 1234);
        String output = formatter.format(result);
        String expected = """
                _12350000│1234
                 1234    │-----
                 ----    │10008
                   _10000
                    9872
                    -----
                      128
                """;
        assertEquals(expected, output);
    }

    @Test
    public void shouldFormatString_WithPositiveNumbersVar9() {
        Result result = divider.divide(12341234, 1);
        String output = formatter.format(result);
        String expected = """
                _12341234│1
                 1       │--------
                 -       │12341234
                 _2
                  2
                  -
                  _3
                   3
                   -
                   _4
                    4
                    -
                    _1
                     1
                     -
                     _2
                      2
                      -
                      _3
                       3
                       -
                       _4
                        4
                        -
                        0
                """;
        assertEquals(expected, output);
    }

    @Test
    public void shouldFormatString_WithPositiveNumbersVar10() {
        Result result = divider.divide(12340035, 1234);
        String output = formatter.format(result);
        String expected = """
                _12340035│1234
                 1234    │-----
                 ----    │10000
                       35
                """;
        assertEquals(expected, output);
    }

    @Test
    public void shouldFormatString_WithPositiveNumbersVar11() {
        Result result = divider.divide(345, 8);
        String output = formatter.format(result);
        String expected = """
                _345│8
                 32 │--
                 -- │43
                 _25
                  24
                  --
                   1
                """;
        assertEquals(expected, output);
    }

    @Test
    public void shouldFormatString_WithPositiveNumbersVar12() {
        Result result = divider.divide(10000, 2);
        String output = formatter.format(result);
        String expected = """
                _10000│2
                 10   │----
                 --   │5000
                     0
                """;
        assertEquals(expected, output);
    }

    @Test
    public void shouldFormatString_WithPositiveNumbersVar13() {
        Result result = divider.divide(10000, 20);
        String output = formatter.format(result);
        String expected = """
                _10000│20
                 100  │---
                 ---  │500
                     0
                """;
        assertEquals(expected, output);
    }

    @Test
    public void shouldFormatString_WithPositiveNumbersVar14() {
        Result result = divider.divide(6546532, 113);
        String output = formatter.format(result);
        String expected = """
                _6546532│113
                 565    │-----
                 ---    │57933
                 _896
                  791
                  ---
                 _1055
                  1017
                  ----
                   _383
                    339
                    ---
                    _442
                     339
                     ---
                     103
                """;
        assertEquals(expected, output);
    }

    @Test
    public void shouldFormatString_WithPositiveNumbersVar15() {
        Result result = divider.divide(405022500, 45);
        String output = formatter.format(result);
        String expected = """
                _405022500│45
                 405      │-------
                 ---      │9000500
                    _225
                     225
                     ---
                         0
                """;
        assertEquals(expected, output);
    }

    @Test
    public void shouldFormatString_WithNegativeDividendVar1() {
        Result result = divider.divide(-78454, 4);
        String output = formatter.format(result);
        String expected = """
                _-78454│4
                  4    │------
                  -    │-19613
                 _38
                  36
                  --
                  _24
                   24
                   --
                    _5
                     4
                     -
                    _14
                     12
                     --
                     -2
                """;
        assertEquals(expected, output);
    }

    @Test
    public void shouldFormatString_WithNegativeDividendVar2() {
        Result result = divider.divide(-630440, 610);
        String output = formatter.format(result);
        String expected = """
                _-630440│610
                  610   │-----
                  ---   │-1033
                  _2044
                   1830
                   ----
                   _2140
                    1830
                    ----
                    -310
                """;
        assertEquals(expected, output);
    }

    @Test
    public void shouldFormatString_WithNegativeDividendVar3() {
        Result result = divider.divide(-12341234, 1234);
        String output = formatter.format(result);
        String expected = """
                _-12341234│1234
                  1234    │------
                  ----    │-10001
                     _1234
                      1234
                      ----
                         0
                """;
        assertEquals(expected, output);
    }

    @Test
    public void shouldFormatString_WithNegativeDividendVar4() {
        Result result = divider.divide(-593593593, 593);
        String output = formatter.format(result);
        String expected = """
                _-593593593│593
                  593      │--------
                  ---      │-1001001
                    _593
                     593
                     ---
                       _593
                        593
                        ---
                          0
                """;
        assertEquals(expected, output);
    }

    @Test
    public void shouldFormatString_WithNegativeDividendVar5() {
        Result result = divider.divide(-12351234, 1234);
        String output = formatter.format(result);
        String expected = """
                _-12351234│1234
                  1234    │------
                  ----    │-10009
                    _11234
                     11106
                     -----
                      -128
                """;
        assertEquals(expected, output);
    }

    @Test
    public void shouldFormatString_WithNegativeDividendVar6() {
        Result result = divider.divide(-12341233, 1234);
        String output = formatter.format(result);
        String expected = """
                _-12341233│1234
                  1234    │------
                  ----    │-10000
                     -1233
                """;
        assertEquals(expected, output);
    }

    @Test
    public void shouldFormatString_WithNegativeDividendVar7() {
        Result result = divider.divide(-12353574, 1234);
        String output = formatter.format(result);
        String expected = """
                _-12353574│1234
                  1234    │------
                  ----    │-10011
                    _1357
                     1234
                     ----
                     _1234
                      1234
                      ----
                         0
                """;
        assertEquals(expected, output);
    }

    @Test
    public void shouldFormatString_WithNegativeDividendVar8() {
        Result result = divider.divide(-12350000, 1234);
        String output = formatter.format(result);
        String expected = """
                _-12350000│1234
                  1234    │------
                  ----    │-10008
                    _10000
                     9872
                     -----
                      -128
                """;
        assertEquals(expected, output);
    }

    @Test
    public void shouldFormatString_WithNegativeDividendVar9() {
        Result result = divider.divide(-12341234, 1);
        String output = formatter.format(result);
        String expected = """
                _-12341234│1
                  1       │---------
                  -       │-12341234
                  _2
                   2
                   -
                   _3
                    3
                    -
                    _4
                     4
                     -
                     _1
                      1
                      -
                      _2
                       2
                       -
                       _3
                        3
                        -
                        _4
                         4
                         -
                         0
                """;
        assertEquals(expected, output);
    }

    @Test
    public void shouldFormatString_WithNegativeDividendVar10() {
        Result result = divider.divide(-12340035, 1234);
        String output = formatter.format(result);
        String expected = """
                _-12340035│1234
                  1234    │------
                  ----    │-10000
                       -35
                """;
        assertEquals(expected, output);
    }

    @Test
    public void shouldFormatString_WithNegativeDividendVar11() {
        Result result = divider.divide(-345, 8);
        String output = formatter.format(result);
        String expected = """
                _-345│8
                  32 │---
                  -- │-43
                  _25
                   24
                   --
                   -1
                """;
        assertEquals(expected, output);
    }

    @Test
    public void shouldFormatString_WithNegativeDividendVar12() {
        Result result = divider.divide(-10000, 2);
        String output = formatter.format(result);
        String expected = """
                _-10000│2
                  10   │-----
                  --   │-5000
                      0
                """;
        assertEquals(expected, output);
    }

    @Test
    public void shouldFormatString_WithNegativeDividendVar13() {
        Result result = divider.divide(-10000, 20);
        String output = formatter.format(result);
        String expected = """
                _-10000│20
                  100  │----
                  ---  │-500
                      0
                """;
        assertEquals(expected, output);
    }

    @Test
    public void shouldFormatString_WithNegativeDividendVar14() {
        Result result = divider.divide(-6546532, 113);
        String output = formatter.format(result);
        String expected = """
                _-6546532│113
                  565    │------
                  ---    │-57933
                  _896
                   791
                   ---
                  _1055
                   1017
                   ----
                    _383
                     339
                     ---
                     _442
                      339
                      ---
                     -103
                """;
        assertEquals(expected, output);
    }

    @Test
    public void shouldFormatString_WithNegativeDividendVar15() {
        Result result = divider.divide(-405022500, 45);
        String output = formatter.format(result);
        String expected = """
                _-405022500│45
                  405      │--------
                  ---      │-9000500
                     _225
                      225
                      ---
                          0
                """;
        assertEquals(expected, output);
    }

    @Test
    public void shouldFormatString_WithNegativeNumberVar1() {
        Result result = divider.divide(405022500, 45);
        String output = formatter.format(result);
        String expected = """
                _405022500│45
                 405      │-------
                 ---      │9000500
                    _225
                     225
                     ---
                         0
                """;
        assertEquals(expected, output);
    }

    @Test
    public void shouldFormatString_WithNegativeNumberVar2() {
        Result result = divider.divide(-78454, -4);
        String output = formatter.format(result);
        String expected = """
                _-78454│-4
                  4    │-----
                  -    │19613
                 _38
                  36
                  --
                  _24
                   24
                   --
                    _5
                     4
                     -
                    _14
                     12
                     --
                     -2
                """;
        assertEquals(expected, output);
    }

    @Test
    public void shouldFormatString_WithNegativeNumberVar3() {
        Result result = divider.divide(-630440, -610);
        String output = formatter.format(result);

        String expected = """
                _-630440│-610
                  610   │----
                  ---   │1033
                  _2044
                   1830
                   ----
                   _2140
                    1830
                    ----
                    -310
                """;
        assertEquals(expected, output);
    }

    @Test
    public void shouldFormatString_WithNegativeNumberVar4() {
        Result result = divider.divide(-12341234, -1234);
        String output = formatter.format(result);
        String expected = """
                _-12341234│-1234
                  1234    │-----
                  ----    │10001
                     _1234
                      1234
                      ----
                         0
                """;
        assertEquals(expected, output);
    }

    @Test
    public void shouldFormatString_WithNegativeNumberVar5() {
        Result result = divider.divide(-593593593, -593);
        String output = formatter.format(result);
        String expected = """
                _-593593593│-593
                  593      │-------
                  ---      │1001001
                    _593
                     593
                     ---
                       _593
                        593
                        ---
                          0
                """;
        assertEquals(expected, output);
    }

    @Test
    public void shouldFormatString_WithNegativeNumberVar6() {
        Result result = divider.divide(-12351234, -1234);
        String output = formatter.format(result);
        String expected = """
                _-12351234│-1234
                  1234    │-----
                  ----    │10009
                    _11234
                     11106
                     -----
                      -128
                """;
        assertEquals(expected, output);
    }

    @Test
    public void shouldFormatString_WithNegativeNumberVar7() {
        Result result = divider.divide(-12341233, -1234);
        String output = formatter.format(result);
        String expected = """
                _-12341233│-1234
                  1234    │-----
                  ----    │10000
                     -1233
                """;
        assertEquals(expected, output);
    }

    @Test
    public void shouldFormatString_WithNegativeNumberVar8() {
        Result result = divider.divide(-12353574, -1234);
        String output = formatter.format(result);
        String expected = """
                _-12353574│-1234
                  1234    │-----
                  ----    │10011
                    _1357
                     1234
                     ----
                     _1234
                      1234
                      ----
                         0
                """;
        assertEquals(expected, output);
    }

    @Test
    public void shouldFormatString_WithNegativeNumberVar9() {
        Result result = divider.divide(-12350000, -1234);
        String output = formatter.format(result);
        String expected = """
                _-12350000│-1234
                  1234    │-----
                  ----    │10008
                    _10000
                     9872
                     -----
                      -128
                """;
        assertEquals(expected, output);
    }

    @Test
    public void shouldFormatString_WithNegativeNumberVar10() {
        Result result = divider.divide(-12341234, -1);
        String output = formatter.format(result);
        String expected = """
                _-12341234│-1
                  1       │--------
                  -       │12341234
                  _2
                   2
                   -
                   _3
                    3
                    -
                    _4
                     4
                     -
                     _1
                      1
                      -
                      _2
                       2
                       -
                       _3
                        3
                        -
                        _4
                         4
                         -
                         0
                """;
        assertEquals(expected, output);
    }

    @Test
    public void shouldFormatString_WithNegativeNumberVar11() {
        Result result = divider.divide(-12340035, -1234);
        String output = formatter.format(result);
        String expected = """
                _-12340035│-1234
                  1234    │-----
                  ----    │10000
                       -35
                """;
        assertEquals(expected, output);
    }

    @Test
    public void shouldFormatString_WithNegativeNumberVar12() {
        Result result = divider.divide(-345, -8);
        String output = formatter.format(result);
        String expected = """
                _-345│-8
                  32 │--
                  -- │43
                  _25
                   24
                   --
                   -1
                """;
        assertEquals(expected, output);
    }

    @Test
    public void shouldFormatString_WithNegativeNumberVar13() {
        Result result = divider.divide(-10000, -2);
        String output = formatter.format(result);
        String expected = """
                _-10000│-2
                  10   │----
                  --   │5000
                      0
                """;
        assertEquals(expected, output);
    }

    @Test
    public void shouldFormatString_WithNegativeNumberVar14() {
        Result result = divider.divide(-10000, -20);
        String output = formatter.format(result);
        String expected = """
                _-10000│-20
                  100  │---
                  ---  │500
                      0
                """;
        assertEquals(expected, output);
    }

    @Test
    public void shouldFormatString_WithNegativeNumberVar15() {
        Result result = divider.divide(-6546532, -113);
        String output = formatter.format(result);
        String expected = """
                _-6546532│-113
                  565    │-----
                  ---    │57933
                  _896
                   791
                   ---
                  _1055
                   1017
                   ----
                    _383
                     339
                     ---
                     _442
                      339
                      ---
                     -103
                """;
        assertEquals(expected, output);
    }

    @Test
    public void shouldFormatString_WithNegativeDivisorVar1() {
        Result result = divider.divide(630440, -610);
        String output = formatter.format(result);

        String expected = """
                _630440│-610
                 610   │-----
                 ---   │-1033
                 _2044
                  1830
                  ----
                  _2140
                   1830
                   ----
                    310
                """;
        assertEquals(expected, output);
    }

    @Test
    public void shouldFormatString_WithNegativeDivisorVar2() {
        Result result = divider.divide(12341234, -1234);
        String output = formatter.format(result);
        String expected = """
                _12341234│-1234
                 1234    │------
                 ----    │-10001
                    _1234
                     1234
                     ----
                        0
                """;
        assertEquals(expected, output);
    }

    @Test
    public void shouldFormatString_WithNegativeDivisorVar3() {
        Result result = divider.divide(593593593, -593);
        String output = formatter.format(result);
        String expected = """
                _593593593│-593
                 593      │--------
                 ---      │-1001001
                   _593
                    593
                    ---
                      _593
                       593
                       ---
                         0
                """;
        assertEquals(expected, output);
    }

    @Test
    public void shouldFormatString_WithNegativeDivisorVar4() {
        Result result = divider.divide(12351234, -1234);
        String output = formatter.format(result);
        String expected = """
                _12351234│-1234
                 1234    │------
                 ----    │-10009
                   _11234
                    11106
                    -----
                      128
                """;
        assertEquals(expected, output);
    }

    @Test
    public void shouldFormatString_WithNegativeDivisorVar5() {
        Result result = divider.divide(12341233, -1234);
        String output = formatter.format(result);
        String expected = """
                _12341233│-1234
                 1234    │------
                 ----    │-10000
                     1233
                """;
        assertEquals(expected, output);
    }

    @Test
    public void shouldFormatString_WithNegativeDivisorVar6() {
        Result result = divider.divide(12353574, -1234);
        String output = formatter.format(result);
        String expected = """
                _12353574│-1234
                 1234    │------
                 ----    │-10011
                   _1357
                    1234
                    ----
                    _1234
                     1234
                     ----
                        0
                """;
        assertEquals(expected, output);
    }

    @Test
    public void shouldFormatString_WithNegativeDivisorVar7() {
        Result result = divider.divide(12350000, -1234);
        String output = formatter.format(result);
        String expected = """
                _12350000│-1234
                 1234    │------
                 ----    │-10008
                   _10000
                    9872
                    -----
                      128
                """;
        assertEquals(expected, output);
    }

    @Test
    public void shouldFormatString_WithNegativeDivisorVar8() {
        Result result = divider.divide(12341234, -1);
        String output = formatter.format(result);
        String expected = """
                _12341234│-1
                 1       │---------
                 -       │-12341234
                 _2
                  2
                  -
                  _3
                   3
                   -
                   _4
                    4
                    -
                    _1
                     1
                     -
                     _2
                      2
                      -
                      _3
                       3
                       -
                       _4
                        4
                        -
                        0
                """;
        assertEquals(expected, output);
    }

    @Test
    public void shouldFormatString_WithNegativeDivisorVar9() {
        Result result = divider.divide(12340035, -1234);
        String output = formatter.format(result);
        String expected = """
                _12340035│-1234
                 1234    │------
                 ----    │-10000
                       35
                """;
        assertEquals(expected, output);
    }

    @Test
    public void shouldFormatString_WithNegativeDivisorVar10() {
        Result result = divider.divide(345, -8);
        String output = formatter.format(result);
        String expected = """
                _345│-8
                 32 │---
                 -- │-43
                 _25
                  24
                  --
                   1
                """;
        assertEquals(expected, output);
    }

    @Test
    public void shouldFormatString_WithNegativeDivisorVar11() {
        Result result = divider.divide(10000, -2);
        String output = formatter.format(result);
        String expected = """
                _10000│-2
                 10   │-----
                 --   │-5000
                     0
                """;
        assertEquals(expected, output);
    }

    @Test
    public void shouldFormatString_WithNegativeDivisorVar12() {
        Result result = divider.divide(10000, -20);
        String output = formatter.format(result);
        String expected = """
                _10000│-20
                 100  │----
                 ---  │-500
                     0
                """;
        assertEquals(expected, output);
    }

    @Test
    public void shouldFormatString_WithNegativeDivisorVar13() {
        Result result = divider.divide(6546532, -113);
        String output = formatter.format(result);
        String expected = """
                _6546532│-113
                 565    │------
                 ---    │-57933
                 _896
                  791
                  ---
                 _1055
                  1017
                  ----
                   _383
                    339
                    ---
                    _442
                     339
                     ---
                     103
                """;
        assertEquals(expected, output);
    }

    @Test
    public void shouldFormatString_WithNegativeDivisorVar14() {
        Result result = divider.divide(405022500, -45);
        String output = formatter.format(result);
        String expected = """
                _405022500│-45
                 405      │--------
                 ---      │-9000500
                    _225
                     225
                     ---
                         0
                """;
        assertEquals(expected, output);
    }
}