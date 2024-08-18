package com.airwallex.app.impl;

import com.airwallex.app.api.Calculate;
import com.airwallex.app.userInput.record.OperationRecord;

import java.math.BigDecimal;
import java.util.Stack;

public class DefaultCalculateImpl implements Calculate {

    private Stack<BigDecimal> digitStack = new Stack<>();

    private Stack<OperationRecord> operationRecordStack = new Stack<>();


    @Override
    public Stack<BigDecimal> getDigitStack(){
        return this.digitStack;
    }

    @Override
    public void pushDigital(BigDecimal userEntry) {
        this.digitStack.push(userEntry);
    }

    @Override
    public BigDecimal popDigital() {
        return this.digitStack.pop();
    }

    @Override
    public void setOperationRecord(OperationRecord record) {
        this.operationRecordStack.push(record);
    }

    @Override
    public OperationRecord getOperationRecord() {
        return this.operationRecordStack.pop();
    }

    @Override
    public int getDigitsStackSize() {
        return this.digitStack.size();
    }

}
