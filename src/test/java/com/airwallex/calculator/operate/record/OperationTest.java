package com.airwallex.calculator.operate.record;

import com.airwallex.calculator.RpnCalculator;
import com.airwallex.calculator.operate.AbstractOperator;
import com.airwallex.calculator.operate.math.AdditionOperator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


/**
 * Test class of Operation
 *
 * @author litingsheng
 * @date 2024/08/21
 */
@RunWith(PowerMockRunner.class)
public class OperationTest {
    @Mock
    private AbstractOperator abstractOperator;

    @InjectMocks
    private Operation operation;

    @Test
    public void testOperationWithIllegalInput() {
        List<BigDecimal> params = new ArrayList<>();
        params.add(new BigDecimal("3"));
        AbstractOperator operator = new AdditionOperator();
        Operation record = new Operation(params, operator);
        Assert.assertNotNull(record);
        Assert.assertEquals(params, record.getParameters());
        Assert.assertEquals(operator, record.getOperator());
    }

    @Test
    public void testOperationWithNullInput() {
        List<BigDecimal> params = new ArrayList<>();
        params.add(new BigDecimal("3"));
        AbstractOperator operator = null;
        Operation record = new Operation(params, operator);
        Assert.assertNotNull(record);
        Assert.assertEquals(params, record.getParameters());
        Assert.assertNull(record.getOperator());
    }
}
