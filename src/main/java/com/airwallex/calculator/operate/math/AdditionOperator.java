package com.airwallex.calculator.operate.math;

import com.airwallex.calculator.api.Calculate;
import com.airwallex.calculator.operate.record.Operation;
import com.airwallex.calculator.operate.enums.OperatorsEnum;

import java.math.BigDecimal;

/**
 * Addition Operator
 *
 * @author litingsheng
 * @date 2024/08/21
 */
public class AdditionOperator extends Operator {


    @Override
    public String getOperatorName() {
        return OperatorsEnum.ADDITION.getCode();
    }

    @Override
    public void performOperation(Calculate calculate) {
        BigDecimal firstInput = calculate.popDigital();
        BigDecimal secondInput = calculate.popDigital();
        BigDecimal result = secondInput.add(firstInput);
        calculate.pushDigital(result);
        Operation record = getOperationRecord(firstInput, secondInput);
        calculate.setOperationRecord(record);
    }
}
