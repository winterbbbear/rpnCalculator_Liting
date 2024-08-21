package com.airwallex.calculator.operate.math;

import com.airwallex.calculator.api.Calculate;
import com.airwallex.calculator.operate.record.Operation;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertFalse;

public class OperatorTest {

    private Operator operatorUnderTest;

    @Before
    public void setUp() {
        operatorUnderTest = new Operator() {
            @Override
            public void performOperation(Calculate calculate) {

            }

            @Override
            public String getOperatorName() {
                return null;
            }
        };
    }

    @Test
    public void testGetOperationRecord() {
        // Setup
        // Run the test
        final Operation result = operatorUnderTest.getOperationRecord(new BigDecimal("0.00"), new BigDecimal("0.00"));

        // Verify the results
    }

    @Test
    public void testIsValidOperation() {
        // Setup
        final Calculate calculate = null;

        // Run the test
        final boolean result = operatorUnderTest.isValidOperation(calculate);

        // Verify the results
        assertFalse(result);
    }

    @Test
    public void testCalculate() {
        // Setup
        final Calculate storage = null;

        // Run the test
        operatorUnderTest.calculate(storage);

        // Verify the results
    }
}
