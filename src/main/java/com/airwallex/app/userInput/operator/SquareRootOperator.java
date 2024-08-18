package com.airwallex.app.userInput.operator;

import com.airwallex.app.api.Calculate;
import com.airwallex.app.userInput.record.OperationRecord;
import com.airwallex.app.userInput.enums.OperatorsEnum;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class SquareRootOperator extends Operator{

    public static final int DECIMAL_PLACES = 15;

    @Override
    public void calculate(Calculate calculate) {
        BigDecimal first = calculate.popDigital();
        if (first.equals(first.abs())) {
            BigDecimal result = new BigDecimal(Math.sqrt(first.doubleValue())).setScale(DECIMAL_PLACES, BigDecimal.ROUND_DOWN);
            calculate.pushDigital(result);
            List<BigDecimal> params = Arrays.asList(first);
            OperationRecord record = new OperationRecord(params, this);;
            calculate.setOperationRecord(record);
        }
        else {
            calculate.pushDigital(first);
            System.err.println("Square root cannot be applied to " + first.stripTrailingZeros());
        }
    }

    @Override
    public String getOperatorName() {
        return OperatorsEnum.SQUAREROOT.getCode();
    }

    @Override
    public void performOperation(Calculate calculate) {

    }
}
