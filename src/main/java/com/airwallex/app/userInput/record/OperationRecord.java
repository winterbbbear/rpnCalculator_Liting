package com.airwallex.app.userInput.record;


import com.airwallex.app.error.ErrorCode;
import com.airwallex.app.error.OperatorErrorCode;
import com.airwallex.app.userInput.operator.AbstractOperator;
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
            System.err.println(OperatorErrorCode.ILLEGAL_ARGUMENT.getDescription());
        }

        this.parameters = parameters;
        this.operator = operator;
    }
}
