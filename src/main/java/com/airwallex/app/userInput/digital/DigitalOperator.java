package com.airwallex.app.userInput.digital;

import com.airwallex.app.api.Calculate;
import com.airwallex.app.userInput.record.Operation;
import com.airwallex.app.userInput.operator.AbstractOperator;


import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

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
    private Operation getOperationRecordFromInputDigits(BigDecimal digit){
        List<BigDecimal> params = Arrays.asList(digit);
        return new Operation(params, null);
    }
}
