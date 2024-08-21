package com.airwallex.calculator.operate.math;

import com.airwallex.calculator.api.Calculate;
import com.airwallex.calculator.impl.DefaultCalculateImpl;
import com.airwallex.calculator.operate.enums.OperatorsEnum;
import com.airwallex.calculator.operate.record.Operation;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.powermock.modules.junit4.PowerMockRunner;

import java.math.BigDecimal;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;

/**
 * Test class of AdditionOperator
 *
 * @author litingsheng
 * @date 2024/08/21
 */
@RunWith(PowerMockRunner.class)
public class AdditionOperatorTest {

    @InjectMocks
    private AdditionOperator additionOperator;

    @Test
    public void testGetOperatorName() {
        assertEquals(OperatorsEnum.ADDITION.getCode(), additionOperator.getOperatorName());
    }

    @Test
    public void testPerformOperationWithNormalInput() {
        Calculate calculate = new DefaultCalculateImpl();
        calculate.pushDigital(new BigDecimal("2"));
        calculate.pushDigital(new BigDecimal("3"));
        additionOperator.performOperation(calculate);
        //0. Assert push Digital into stack operation
        Assert.assertNotNull(calculate.getDigitStack());
        //1. Verify stack size
        Assert.assertEquals(calculate.getDigitStack().size(), 1);
        BigDecimal result = calculate.popDigital();
        //2. Assert the result
        Assert.assertEquals(result, new BigDecimal("5"));
    }

    @Test
    public void testOperationRecord() {
        Operation operation = additionOperator.getOperationRecord(new BigDecimal("2"),new BigDecimal("3"));
        Assert.assertThat(operation, is(notNullValue()));
        Assert.assertThat(operation.getParameters().size(), is(equalTo(2)));
        Assert.assertThat(operation.getParameters().get(0), is(equalTo(new BigDecimal(3))));
        Assert.assertThat(operation.getParameters().get(1), is(equalTo(new BigDecimal(2))));
    }
}