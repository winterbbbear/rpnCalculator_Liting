package com.airwallex.calculator.operate.math;

import com.airwallex.calculator.operate.record.Operation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;

import java.math.BigDecimal;

/**
 * Test class of Operator
 *
 * @author litingsheng
 * @date 2024/08/21
 */
@RunWith(PowerMockRunner.class)
public class OperatorTest {

    private Operator operator;

    @Before
    public void setUp() {
        this.operator = new AdditionOperator();
    }

    @Test
    public void testGetOperationRecord(){
        Operation operation = operator.getOperationRecord(new BigDecimal("2"), new BigDecimal("3"));
        Assert.assertNotNull(operation.getParameters());
        Assert.assertEquals(operation.getParameters().size(), 2);
    }


}
