package com.airwallex.calculator.impl;

import com.airwallex.calculator.api.Calculate;
import com.airwallex.calculator.operate.record.Operation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * implementation of Calculate api
 *
 * @author litingsheng
 * @date 2024/08/20
 */
public class DefaultCalculateImpl implements Calculate {

    private Stack<BigDecimal> digitStack = new Stack<>();

    private Stack<Operation> operationStack = new Stack<>();

    private static final String SPACE = " ";

    private static final int ZERO = 0;

    private static final int TEN = 10;


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
    public void printStack() {
        System.out.print("stack: ");
        List<BigDecimal> elements = new ArrayList<>(digitStack);
        elements.forEach(e -> {
            System.out.print((ZERO == e.scale()) ? e : format10Digits(e.stripTrailingZeros()));
            System.out.print(SPACE);
        });
        System.out.println();
    }


    private static String format10Digits(BigDecimal digit) {
        if (digit != null && TEN <= digit.scale()) {
            // 10 scale and rounding down
            return digit.setScale(10, RoundingMode.DOWN).toString();
        } else {
            return digit.toString();
        }
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
