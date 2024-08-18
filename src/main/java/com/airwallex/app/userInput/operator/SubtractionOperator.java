package com.airwallex.app.userInput.operator;

import com.airwallex.app.api.Calculate;
import com.airwallex.app.userInput.record.Operation;
import com.airwallex.app.userInput.enums.OperatorsEnum;

import java.math.BigDecimal;

public class SubtractionOperator extends Operator {

    @Override
    public String getOperatorName() {
        return OperatorsEnum.SUBTRACTION.getCode();
    }

    @Override
    public void performOperation(Calculate calculate) {
        BigDecimal first = calculate.popDigital();
        BigDecimal second = calculate.popDigital();
        BigDecimal result = second.subtract(first);
        calculate.pushDigital(result);
        Operation record = this.getOperationRecord(first, second);
        calculate.setOperationRecord(record);
    }
}
