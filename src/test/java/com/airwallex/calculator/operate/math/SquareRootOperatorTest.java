package com.airwallex.calculator.operate.math;

import com.airwallex.calculator.api.Calculate;
import com.airwallex.calculator.impl.DefaultCalculateImpl;
import com.airwallex.calculator.operate.enums.OperatorsEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.powermock.modules.junit4.PowerMockRunner;
import java.math.BigDecimal;
import static org.junit.Assert.assertEquals;

@RunWith(PowerMockRunner.class)
public class SquareRootOperatorTest {

    @InjectMocks
    private SquareRootOperator squareRootOperator;

    @Test
    public void testCalculateWithNormalInput() {
        Calculate calculate = new DefaultCalculateImpl();
        calculate.pushDigital(new BigDecimal("4"));
        squareRootOperator.calculate(calculate);
        //0. Assert push Digital into stack operation
        Assert.assertNotNull(calculate.getDigitStack());
        //1. Verify stack size
        Assert.assertEquals(calculate.getDigitStack().size(), 1);
        BigDecimal result = calculate.popDigital();
        //2. Assert the result, also test the scale of output
        Assert.assertEquals(result, new BigDecimal("2.000000000000000"));
    }

    @Test
    public void testGetOperatorName() {
        assertEquals(OperatorsEnum.SQUARE_ROOT.getCode(), squareRootOperator.getOperatorName());
    }
}
