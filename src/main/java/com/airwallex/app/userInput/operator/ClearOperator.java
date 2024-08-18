package com.airwallex.app.userInput.operator;

import com.airwallex.app.api.Calculate;
import com.airwallex.app.userInput.record.OperationRecord;
import com.airwallex.app.userInput.enums.OperatorsEnum;
import org.apache.commons.collections4.CollectionUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ClearOperator implements AbstractOperator {

    @Override
    public String getOperatorName() {
        return OperatorsEnum.CLEAR.getCode();
    }

    @Override
    public void calculate(Calculate calculate){
        List<BigDecimal> elements = new ArrayList<>();
        BigDecimal digit;
        while(!calculate.getDigitStack().isEmpty()){
            digit = calculate.popDigital();
            elements.add(digit);
        }
        if (CollectionUtils.isNotEmpty(elements)) {
            Optional<OperationRecord> record = this.getOperationRecordByList(elements);
            if(record.isPresent()) {
                calculate.setOperationRecord(record.get());
            }
        }
    }

    private Optional<OperationRecord> getOperationRecordByList(List<BigDecimal> elements) {
        if (CollectionUtils.isNotEmpty(elements)) {
            Collections.reverse(elements);
            return Optional.of(new OperationRecord(elements, this));
        }
        return Optional.empty();
    }
}
