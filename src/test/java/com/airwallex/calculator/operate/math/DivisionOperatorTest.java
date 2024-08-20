package com.airwallex.calculator.operate.math;

import com.airwallex.calculator.api.Calculate;
import com.airwallex.calculator.operate.enums.OperatorsEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;

@RunWith(PowerMockRunner.class)
public class DivisionOperatorTest {

    @InjectMocks
    private DivisionOperator divisionOperator;

    @Test
    public void testGetOperatorName() {
        assertEquals(OperatorsEnum.DIVISION.getCode(), divisionOperator.getOperatorName());
    }

    @Test
    public void testPerformOperation() {
        Calculate calculate = null;

        // Run the test
        divisionOperator.performOperation(calculate);

        // Verify the results
    }
}
