package com.airwallex.calculator.operate.math;

import com.airwallex.calculator.api.Calculate;
import com.airwallex.calculator.operate.record.Operation;
import com.airwallex.calculator.operate.enums.OperatorsEnum;

import java.math.BigDecimal;

/**
 * Multiplication Operator
 *
 * @author litingsheng
 * @date 2024/08/21
 */
public class MultiplicationOperator extends Operator{

    @Override
    public String getOperatorName() {
        return OperatorsEnum.MULTIPLICATION.getCode();
    }

    @Override
    public void performOperation(Calculate calculate) {
        BigDecimal first = calculate.popDigital();
        BigDecimal second = calculate.popDigital();
        BigDecimal result = second.multiply(first);
        calculate.pushDigital(result);
        Operation record = this.getOperationRecord(first, second);
        calculate.setOperationRecord(record);
    }
}
