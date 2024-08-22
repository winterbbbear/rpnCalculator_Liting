package com.airwallex.calculator.operate.digital;

import com.airwallex.calculator.api.Calculate;
import com.airwallex.calculator.operate.record.Operation;
import com.airwallex.calculator.operate.AbstractOperator;


import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

/**
 * Class of digital operator
 *
 * @author litingsheng
 * @date 2024/08/21
 */
public class DigitalOperator implements AbstractOperator {

    private BigDecimal digits;

    public DigitalOperator(String userEntered) {
        this.digits = new BigDecimal(userEntered);
    }

    @Override
    public void calculate(Calculate calculate) {
        calculate.pushDigital(digits);
        Operation record = getOperationRecordFromInputDigits(digits);
        calculate.setOperationRecord(record);
    }

    @Override
    public String getOperatorName() {
        return null;
    }

    private Operation getOperationRecordFromInputDigits(BigDecimal digit) {
        List<BigDecimal> params = Collections.singletonList(digit);
        return new Operation(params, null);
    }
}
