package com.airwallex.app.userEnter.operator;

import com.airwallex.app.api.Calculate;
import com.airwallex.app.record.OperationRecord;
import com.airwallex.app.userEnter.enums.OperatorsEnum;

import java.math.BigDecimal;

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
        OperationRecord record = this.getOperationRecord(first, second);
        calculate.setOperationRecord(record);
    }
}
