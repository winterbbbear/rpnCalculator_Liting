package com.airwallex.app.userInput.operator;

import com.airwallex.app.api.Calculate;
import com.airwallex.app.userInput.record.Operation;
import com.airwallex.app.userInput.enums.OperatorsEnum;

import java.math.BigDecimal;

public class AdditionOperator extends Operator {


    @Override
    public String getOperatorName() {
        return OperatorsEnum.ADDITION.getCode();
    }

    @Override
    public void performOperation(Calculate calculate) {
        BigDecimal first = calculate.popDigital();
        BigDecimal second = calculate.popDigital();
        BigDecimal result = second.add(first);
        calculate.pushDigital(result);
        Operation record = getOperationRecord(first, second);
        calculate.setOperationRecord(record);
    }
}
