package com.airwallex.calculator.operate.math;

import com.airwallex.calculator.api.Calculate;
import com.airwallex.calculator.operate.enums.OperatorsEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;

@RunWith(PowerMockRunner.class)
public class MultiplicationOperatorTest {

    @InjectMocks
    private MultiplicationOperator multiplicationOperator;

    @Test
    public void testGetOperatorName() {
        assertEquals(OperatorsEnum.MULTIPLICATION.getCode(), multiplicationOperator.getOperatorName());
    }

    @Test
    public void testPerformOperation() {
        Calculate calculate = null;

        multiplicationOperator.performOperation(calculate);

    }
}
