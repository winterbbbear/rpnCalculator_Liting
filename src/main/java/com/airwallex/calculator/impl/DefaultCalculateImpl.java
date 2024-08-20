package com.airwallex.calculator.impl;

import com.airwallex.calculator.api.Calculate;
import com.airwallex.calculator.operate.record.Operation;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * implementation
 *
 * @author litingsheng
 * @date 2024/08/20
 */
public class DefaultCalculateImpl implements Calculate {

    private Stack<BigDecimal> digitStack = new Stack<>();

    private Stack<Operation> operationStack = new Stack<>();


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
    public void setOperationRecord(Operation record) {
        this.operationStack.push(record);
    }

    @Override
    public Operation getOperationRecord() {
        return this.operationStack.pop();
    }

    @Override
    public int getDigitsStackSize() {
        return this.digitStack.size();
    }

}
