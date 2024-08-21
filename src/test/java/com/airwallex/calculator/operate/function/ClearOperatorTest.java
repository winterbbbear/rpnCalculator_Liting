package com.airwallex.calculator.operate.function;

import com.airwallex.calculator.impl.DefaultCalculateImpl;
import com.airwallex.calculator.operate.factory.CalculatorFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.powermock.modules.junit4.PowerMockRunner;

import java.math.BigDecimal;


@RunWith(PowerMockRunner.class)
public class ClearOperatorTest {

    @InjectMocks
    private ClearOperator clearOperator;

    @Test
    public void testCalculateInClearOperator() {
        DefaultCalculateImpl calculator = CalculatorFactory.getDefaultCalculator();
        calculator.pushDigital(new BigDecimal("2"));
        clearOperator.calculate(calculator);
        Assert.assertNotNull(calculator);
        Assert.assertNotNull(calculator.getOperationRecord());
    }

}