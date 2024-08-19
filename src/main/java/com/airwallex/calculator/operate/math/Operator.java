package com.airwallex.calculator.operate.math;

import com.airwallex.calculator.api.Calculate;
import com.airwallex.calculator.operate.AbstractOperator;
import com.airwallex.calculator.operate.record.Operation;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.List;

public abstract class Operator implements AbstractOperator {

    private static final Integer TWO = 2;

    protected Operation getOperationRecord(BigDecimal first, BigDecimal second) {
        List<BigDecimal> params = Arrays.asList(second, first);
        return new Operation(params, this);
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
