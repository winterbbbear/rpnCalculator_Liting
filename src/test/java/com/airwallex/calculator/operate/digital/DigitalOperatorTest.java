package com.airwallex.calculator.operate.digital;

import com.airwallex.calculator.api.Calculate;
import com.airwallex.calculator.impl.DefaultCalculateImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
public class DigitalOperatorTest {

    private DigitalOperator digitalOperator;

    @Before
    public void setUp() {
        this.digitalOperator = new DigitalOperator("123");
    }

    @Test
    public void testDigitalOperatorConstruction() {
        String userEntered = "123";
        DigitalOperator userEntry = new DigitalOperator(userEntered);
        Assert.assertNotNull(userEntry);
    }

    @Test
    public void testCalculateWithInput() {
        Calculate calculate = new DefaultCalculateImpl();
        digitalOperator.calculate(calculate);
        Assert.assertNotNull(calculate.getOperationRecord());
    }
}