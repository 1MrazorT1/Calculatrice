package fr.ensicaen.tp1;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void testValidAddition() {
        assertEquals("5.0", Calculator.calculate("2 + 3"));
    }

    @Test
    public void testValidSubtraction() {
        assertEquals("4.0", Calculator.calculate("10 - 6"));
    }

    @Test
    public void testDivisionByZero() {
        assertEquals("Error", Calculator.calculate("9 / 0"));
    }

    @Test
    public void testInvalidExpression() {
        assertEquals("Error", Calculator.calculate("2 + "));
    }

    @Test
    public void testComplexExpression() {
        assertEquals("10.0", Calculator.calculate("2 + 3 * 4 - 5 / 1 + 1"));
    }

    @Test
    public void testEmptyExpression() {
        assertEquals("Error", Calculator.calculate(""));
    }

    @Test
    public void testLargeNumbers() {
        assertEquals("1.0E18", Calculator.calculate("10^18"));
        assertEquals("2.0E18", Calculator.calculate("10^18 + 10^18"));
    }

    @Test
    public void testSmallNumbersPrecision() {
        assertEquals("1.0E-10", Calculator.calculate("10^-10"));
        assertEquals("2.0E-10", Calculator.calculate("10^-10 + 10^-10"));
    }

    @Test
    public void testLargeAndSmallNumberCombination() {
        assertEquals("1.0E18", Calculator.calculate("10^18 + 0.000000000000000001"));
    }

    @Test
    public void testMultiplicationWithLargeNumbers() {
        assertEquals("1.0E36", Calculator.calculate("10^18 * 10^18"));
    }

    @Test
    public void testDivisionWithSmallNumbers() {
        assertEquals("1.0E12", Calculator.calculate("10 / 0.00000000001"));
    }
}
