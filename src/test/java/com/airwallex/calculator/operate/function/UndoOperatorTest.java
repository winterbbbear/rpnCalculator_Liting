package com.airwallex.calculator.operate.function;

import com.airwallex.calculator.error.OperatorErrorCode;
import com.airwallex.calculator.impl.DefaultCalculateImpl;
import com.airwallex.calculator.operate.factory.CalculatorFactory;
import com.airwallex.calculator.operate.record.Operation;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.powermock.modules.junit4.PowerMockRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Test class of UndoOperator
 *
 * @author litingsheng
 * @date 2024/08/21
 */
@RunWith(PowerMockRunner.class)
public class UndoOperatorTest {

    @InjectMocks
    private UndoOperator undoOperator;

    @Test
    public void testCalculateInClearOperator() {
        DefaultCalculateImpl calculator = CalculatorFactory.getDefaultCalculator();
        List<BigDecimal> elements = new ArrayList<>();
        elements.add(new BigDecimal("2"));
        Operation operation = new Operation(elements, new ClearOperator());
        calculator.pushDigital(new BigDecimal("2"));
        calculator.setOperationRecord(operation);
        undoOperator.calculate(calculator);
        Assert.assertNotNull(calculator);
        Assert.assertNotNull(calculator.getDigitStack());
    }

}