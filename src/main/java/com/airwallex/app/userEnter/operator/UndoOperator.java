package com.airwallex.app.userEnter.operator;

import com.airwallex.app.api.Calculate;
import com.airwallex.app.record.OperationRecord;
import com.airwallex.app.userEnter.enums.OperatorsEnum;

import java.math.BigDecimal;

public class UndoOperator implements AbstractOperator {
    @Override
    public void calculate(Calculate calculate) {
        //get history from OperationRecord
        OperationRecord record = calculate.getOperationRecord();
        AbstractOperator operator = record.getOperator();
        if (!((null != operator) && ((operator instanceof ClearOperator)))) {
            calculate.popDigital();
        }
        if (null != record.getOperator()) {
            for(BigDecimal digit : record.getParameters()) {
                calculate.pushDigital(digit);
            }
        }
    }

    @Override
    public String getOperatorName() {
        return OperatorsEnum.UNDO.getCode();
    }

}
