package com.airwallex.calculator.operate.math;

import com.airwallex.calculator.api.Calculate;
import com.airwallex.calculator.error.OperatorErrorCode;
import com.airwallex.calculator.operate.enums.OperatorsEnum;
import com.airwallex.calculator.operate.record.Operation;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Division Operator
 *
 * @author litingsheng
 * @date 2024/08/20
 */
public class DivisionOperator extends Operator {

    public static final int DECIMAL_PLACES = 15;

    @Override
    public String getOperatorName() {
        return OperatorsEnum.DIVISION.getCode();
    }

    @Override
    public void performOperation(Calculate calculate) {
        BigDecimal first = calculate.popDigital();
        if (BigDecimal.ZERO.equals(first)) {
            calculate.pushDigital(first);
            System.err.println(OperatorErrorCode.ZERO_DIVISOR.getDescription());
            return;
        }
        BigDecimal secondInput = calculate.popDigital();
        BigDecimal total = secondInput.divide(first, DECIMAL_PLACES, RoundingMode.DOWN);
        calculate.pushDigital(total);
        Operation record = this.getOperationRecord(first, secondInput);
        calculate.setOperationRecord(record);
    }
}
