package com.airwallex.app.utils;

import com.airwallex.app.userInput.enums.OperatorsEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.powermock.modules.junit4.PowerMockRunner;



@RunWith(PowerMockRunner.class)
public class CalculatorUtilsTest {

    @InjectMocks
    private CalculatorUtils calculatorUtils;

    private static final String TEST_LINE = "Operator: + (position: " +
            1 +
            "): insufficient parameters";
    @Test
    public void testPrintEmptyStackErrorMessage() {
        String result = CalculatorUtils.printEmptyStackErrorMessage(OperatorsEnum.ADDITION.getCode(), 1);
        Assert.assertEquals(TEST_LINE, result);
    }
}