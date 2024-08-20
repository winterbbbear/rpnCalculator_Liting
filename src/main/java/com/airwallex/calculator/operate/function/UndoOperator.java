package com.airwallex.calculator.operate.function;

import com.airwallex.calculator.api.Calculate;
import com.airwallex.calculator.operate.AbstractOperator;
import com.airwallex.calculator.operate.record.Operation;
import com.airwallex.calculator.operate.enums.OperatorsEnum;

import java.math.BigDecimal;

/**
 * Undo function operator
 *
 * @author litingsheng
 * @date 2024/08/21
 */
public class UndoOperator implements AbstractOperator {

    @Override
    public void calculate(Calculate calculate) {
        Operation record = calculate.getOperationRecord();
        AbstractOperator operator = record.getOperator();
        if (null == operator) {
            return;
        }
        if (!(operator instanceof ClearOperator)) {
            calculate.popDigital();
        }
        if (null != record.getOperator()) {
            for (BigDecimal digit : record.getParameters()) {
                calculate.pushDigital(digit);
            }
        }
    }

    @Override
    public String getOperatorName() {
        return OperatorsEnum.UNDO.getCode();
    }

}
