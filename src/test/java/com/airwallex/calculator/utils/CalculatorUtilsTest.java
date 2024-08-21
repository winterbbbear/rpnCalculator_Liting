package com.airwallex.calculator.utils;

import com.airwallex.calculator.operate.enums.OperatorsEnum;
import com.airwallex.calculator.operate.factory.UserInputFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.powermock.modules.junit4.PowerMockRunner;

import java.math.BigDecimal;
import java.util.Stack;

import static org.junit.Assert.assertEquals;


/**
 * Test of Calculator Util
 *
 * @author litingsheng
 * @date 2024/08/21
 */
@RunWith(PowerMockRunner.class)
public class CalculatorUtilsTest {

    @InjectMocks
    private CalculatorUtils calculatorUtils;

    private static final String OPERATOR_INSUFFICIENT_PARAM = "operator: + (position: 1): insufficient parameters";

    @Test
    public void testPrintEmptyStackErrorMessage() {
        assertEquals(OPERATOR_INSUFFICIENT_PARAM, CalculatorUtils.printEmptyStackErrorMessage(OperatorsEnum.ADDITION.getCode(), 1));
    }
}
