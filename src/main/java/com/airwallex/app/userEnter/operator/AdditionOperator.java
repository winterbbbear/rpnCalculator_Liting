package com.airwallex.app.userEnter.operator;

import com.airwallex.app.api.Calculate;
import com.airwallex.app.record.OperationRecord;
import com.airwallex.app.userEnter.enums.OperatorsEnum;

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
        OperationRecord record = getOperationRecord(first, second);
        calculate.setOperationRecord(record);
    }
}
