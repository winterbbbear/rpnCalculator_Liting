package com.airwallex.app.record;

import com.airwallex.app.userEnter.operator.AbstractOperator;
import org.apache.commons.collections4.CollectionUtils;

import java.math.BigDecimal;
import java.util.List;

public class OperationRecord {

    private List<BigDecimal> parameters;

    private AbstractOperator operator;

    public List<BigDecimal> getParameters() {
        return parameters;
    }

    public AbstractOperator getOperator() {
        return operator;
    }

    public OperationRecord(List<BigDecimal> parameters, AbstractOperator operator) {
        if (CollectionUtils.isEmpty(parameters)) {
            throw new IllegalArgumentException("parameters cannot be null");
        }
        this.parameters = parameters;
        this.operator = operator;
    }
}
