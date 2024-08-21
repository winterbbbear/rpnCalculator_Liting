package com.airwallex.calculator.operate.math;

import com.airwallex.calculator.api.Calculate;
import com.airwallex.calculator.error.OperatorErrorCode;
import com.airwallex.calculator.operate.record.Operation;
import com.airwallex.calculator.operate.enums.OperatorsEnum;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.List;

/**
 * SquareRoot Operator
 *
 * @author litingsheng
 * @date 2024/08/21
 */
public class SquareRootOperator extends Operator {

    public static final int DECIMAL_PLACES = 15;

    @Override
    public void calculate(Calculate calculate) {
        BigDecimal firstInput = calculate.popDigital();
        if (firstInput.equals(firstInput.abs())) {
            BigDecimal result = BigDecimal.valueOf(Math.sqrt(firstInput.doubleValue()))
                    .setScale(DECIMAL_PLACES, RoundingMode.DOWN);
            calculate.pushDigital(result);
            List<BigDecimal> params = Collections.singletonList(firstInput);
            Operation record = new Operation(params, this);;
            calculate.setOperationRecord(record);
        }
        else {
            calculate.pushDigital(firstInput);
            System.err.println(OperatorErrorCode.SQUARE_ROOT_ERROR.getDescription());
        }
    }

    @Override
    public String getOperatorName() {
        return OperatorsEnum.SQUARE_ROOT.getCode();
    }

    @Override
    public void performOperation(Calculate calculate) {
    }
}
