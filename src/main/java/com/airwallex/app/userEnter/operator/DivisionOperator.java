package com.airwallex.app.userEnter.operator;

import com.airwallex.app.api.Calculate;
import com.airwallex.app.record.OperationRecord;
import com.airwallex.app.userEnter.enums.OperatorsEnum;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DivisionOperator extends Operator{

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
            System.err.println("Divisor cannot be zero!");
            return;
        }
        BigDecimal second = calculate.popDigital();
        BigDecimal total = second.divide(first, DECIMAL_PLACES, RoundingMode.DOWN);
        calculate.pushDigital(total);
        OperationRecord record = this.getOperationRecord(first, second);
        calculate.setOperationRecord(record);
    }
}
