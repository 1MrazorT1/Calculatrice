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
}
