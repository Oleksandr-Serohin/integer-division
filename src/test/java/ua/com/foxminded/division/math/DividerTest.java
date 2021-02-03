package ua.com.foxminded.division.math;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.com.foxminded.division.model.Result;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DividerTest {

    Divider divider;
    Result exp, act;

    @BeforeEach
    public void setUp() {
        divider = new Divider();
    }

    @Test
    void testAssertTrue_DivideRightCalculated() {
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
        final int numbersСycleMinesOne = 4;
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
        exp = new Result(dividend,
                divisor,
                quotient,
                remainder,
                longChar,
                subtrahend,
                minuend,
                numbersTab,
                numbersCycle,
                longMinued,
                longLastTab,
                numbersTabMinesOne,
                numbersСycleMinesOne,
                tabOneForStringTwo,
                tabTwoForStringTwo,
                longCharMinesOne);
        act = divider.divide(78945, 4);

        assertEquals(exp, act);
    }
}
