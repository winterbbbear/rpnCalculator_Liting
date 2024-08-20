package com.airwallex.calculator.operate.math;

import com.airwallex.calculator.api.Calculate;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SquareRootOperatorTest {

    private SquareRootOperator squareRootOperator;

    @Test
    public void testCalculate() {
        // Setup
        final Calculate calculate = null;

        // Run the test
        squareRootOperator.calculate(calculate);

        // Verify the results
    }

    @Test
    public void testGetOperatorName() {
        assertEquals("code", squareRootOperator.getOperatorName());
    }

    @Test
    public void testPerformOperation() {
        squareRootOperator.performOperation(null);
    }
}
