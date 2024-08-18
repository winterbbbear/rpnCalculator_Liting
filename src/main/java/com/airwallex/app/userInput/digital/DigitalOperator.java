package com.airwallex.app.userInput.digital;

import com.airwallex.app.api.Calculate;
import com.airwallex.app.userInput.record.OperationRecord;
import com.airwallex.app.userInput.operator.AbstractOperator;


import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class DigitalOperator implements AbstractOperator {

    private BigDecimal digits;

    public DigitalOperator(final String userEntered) {
        this.digits = new BigDecimal(userEntered);
    }

    @Override
    public void calculate(Calculate storage) {
        storage.pushDigital(digits);
        OperationRecord record = getOperationRecordFromInputDigits(digits);
        storage.setOperationRecord(record);
    }
    @Override
    public String getOperatorName() {
        return null;
    }
    private OperationRecord getOperationRecordFromInputDigits(BigDecimal digit){
        List<BigDecimal> params = Arrays.asList(digit);
        return new OperationRecord(params, null);
    }
}
