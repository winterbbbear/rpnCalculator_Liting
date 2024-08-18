package com.airwallex.app.userEnter.operator;

import com.airwallex.app.api.Calculate;
import com.airwallex.app.record.OperationRecord;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.List;

public abstract class Operator implements AbstractOperator {

    private static final Integer TWO = 2;

    protected OperationRecord getOperationRecord(BigDecimal first, BigDecimal second) {
        List<BigDecimal> params = Arrays.asList(second, first);
        return new OperationRecord(params, this);
    }

    protected boolean isValidOperation(Calculate calculate) {
        if (calculate.getDigitsStackSize() < TWO) {
            throw new EmptyStackException();
        }
        return true;
    }

    @Override
    public void calculate(Calculate storage) {
        if (isValidOperation(storage)) {
            performOperation(storage);
        }
    }

    public abstract void performOperation(Calculate calculate);


}
