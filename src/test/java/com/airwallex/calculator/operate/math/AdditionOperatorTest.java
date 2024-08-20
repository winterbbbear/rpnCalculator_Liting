package com.airwallex.calculator.operate.math;

import com.airwallex.calculator.operate.enums.OperatorsEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;


@RunWith(PowerMockRunner.class)
public class AdditionOperatorTest {

    @InjectMocks
    private AdditionOperator additionOperator;

    @Test
    public void testGetOperatorName() {
        assertEquals(OperatorsEnum.ADDITION.getCode(), additionOperator.getOperatorName());
    }

    @Test
    public void testPerformOperation() {
    }
}