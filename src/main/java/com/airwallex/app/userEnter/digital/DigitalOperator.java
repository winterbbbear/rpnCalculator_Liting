package com.airwallex.app.userEnter.digital;

import com.airwallex.app.api.Calculate;
import com.airwallex.app.record.OperationRecord;
import com.airwallex.app.userEnter.operator.AbstractOperator;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class DigitalOperator implements AbstractOperator {

    private BigDecimal digits;

    public DigitalOperator(final String userEntered) {
        this.digits = new BigDecimal(userEntered);
    }

    @Override
    public void calculate(Calculate storage) {
        storage.pushDigital(digits);
        OperationRecord record = toOperationRecord().apply(digits);
        storage.setOperationRecord(record);
    }

    @Override
    public String getOperatorName() {
        return null;
    }

    static Function<BigDecimal, OperationRecord> toOperationRecord() {
        return d -> {
            List<BigDecimal> params = Arrays.asList(d);
            return new OperationRecord(params, null);
        };
    }
}
