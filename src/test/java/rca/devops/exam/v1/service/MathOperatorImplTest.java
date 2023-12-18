package rca.devops.exam.v1.service;

import org.junit.jupiter.api.Test;
import rca.devops.exam.v1.exception.InvalidOperationException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MathOperatorImplTest {

    private final MathOperator mathOperator = new MathOperatorImpl();

    @Test
    public void testDoMathAddition() throws InvalidOperationException {
        double result = mathOperator.doMath(5, 3, "+");
        assertEquals(8, result);
    }

    @Test
    public void testDoMathSubtraction() throws InvalidOperationException {
        double result = mathOperator.doMath(5, 3, "-");
        assertEquals(2, result);
    }

    @Test
    public void testDoMathMultiplication() throws InvalidOperationException {
        double result = mathOperator.doMath(5, 3, "*");
        assertEquals(15, result);
    }

    @Test
    public void testDoMathDivision() throws InvalidOperationException {
        double result = mathOperator.doMath(6, 3, "/");
        assertEquals(2, result);
    }

    @Test
    public void testDoMathDivisionByZero() {
        assertThrows(InvalidOperationException.class, () -> mathOperator.doMath(5, 0, "/"));
    }

    @Test
    public void testDoMathUnknownOperation() {
        assertThrows(RuntimeException.class, () -> mathOperator.doMath(5, 3, "^"));
    }
}