package com.airwallex.calculator.factory;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Test class of CalculatorFactory
 *
 * @author litingsheng
 * @date 2024/08/21
 */
@RunWith(PowerMockRunner.class)
public class CalculatorFactoryTest {

    @Test
    public void testGetDefaultCalculator() {
        Assert.assertNotNull(CalculatorFactory.getDefaultCalculator());
    }
}