package com.airwallex.calculator.impl;

import com.airwallex.calculator.api.Calculate;
import com.airwallex.calculator.operate.math.AdditionOperator;
import com.airwallex.calculator.operate.record.Operation;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.powermock.modules.junit4.PowerMockRunner;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.EmptyStackException;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

@RunWith(PowerMockRunner.class)
public class DefaultCalculateImplTest {

    @InjectMocks
    private DefaultCalculateImpl defaultCalculateImpl;

    @Test
    public void whenConstructorCalledThenAObjectShouldReturn() {
        DefaultCalculateImpl calculate = new DefaultCalculateImpl();
        assertNotNull(calculate);
    }

    @Test
    public void testPushDigitalWithNormalInput() {
        defaultCalculateImpl.pushDigital(new BigDecimal("0.00"));
        Assert.assertNotNull(defaultCalculateImpl.getDigitStack());
    }


    @Test
    public void testDefaultCalculateWithNormalInput() {
        assertEmptyStack(this.defaultCalculateImpl);
        BigDecimal digit = new BigDecimal("0.00");
        defaultCalculateImpl.pushDigital(digit);
        BigDecimal popResult = defaultCalculateImpl.popDigital();
        assertNotNull(popResult);
        assertEquals(digit, popResult);
        assertEmptyStack(defaultCalculateImpl);
    }

    @Test
    public void testSetOperationRecordWithSuccessOperation() {
        Operation record = new Operation(Arrays.asList(new BigDecimal("0.00")), new AdditionOperator());
        defaultCalculateImpl.setOperationRecord(record);
        Operation getStack = defaultCalculateImpl.getOperationRecord();
        Assert.assertNotNull(getStack);
        Assert.assertEquals(record, getStack);
    }

    private void assertEmptyStack(Calculate calculate) {
        try {
            calculate.popDigital();
            fail("reached unexpected point!");
        } catch (Exception e) {
            assertTrue(e instanceof EmptyStackException);
        }
    }
}
