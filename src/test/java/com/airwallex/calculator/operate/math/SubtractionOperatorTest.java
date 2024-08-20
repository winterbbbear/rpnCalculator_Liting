package com.airwallex.calculator.operate.math;

import com.airwallex.calculator.api.Calculate;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SubtractionOperatorTest {

    private SubtractionOperator subtractionOperator;


    @Test
    public void testGetOperatorName() {
        assertEquals("code", subtractionOperator.getOperatorName());
    }

    @Test
    public void testPerformOperation() {
        // Setup
        final Calculate calculate = null;

        // Run the test
        subtractionOperator.performOperation(calculate);

        // Verify the results
    }
}
