package com.airwallex.calculator.operate.record;


import com.airwallex.calculator.error.OperatorErrorCode;
import com.airwallex.calculator.operate.AbstractOperator;
import org.apache.commons.collections4.CollectionUtils;

import java.math.BigDecimal;
import java.util.List;

public class Operation {

    private List<BigDecimal> parameters;

    private AbstractOperator operator;

    public List<BigDecimal> getParameters() {
        return parameters;
    }

    public AbstractOperator getOperator() {
        return operator;
    }

    public Operation(List<BigDecimal> parameters, AbstractOperator operator) {
        if (CollectionUtils.isEmpty(parameters)) {
            System.err.println(OperatorErrorCode.ILLEGAL_ARGUMENT.getDescription());
        }

        this.parameters = parameters;
        this.operator = operator;
    }
}
