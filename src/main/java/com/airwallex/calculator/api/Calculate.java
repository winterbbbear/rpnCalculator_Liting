package com.airwallex.calculator.api;

import com.airwallex.calculator.operate.record.Operation;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * calculate implements using stacks
 *
 * @author litingsheng
 * @date 2024/08/20
 */
public interface Calculate {

    /**
     * get digits from operation stack
     *
     * @return BigDecimal Stack
     */
    Stack<BigDecimal> getDigitStack();

    /**
     * push digits and store the digits into operation record
     *
     * @param userInput digital input
     * @return void
     */
    void pushDigital(BigDecimal userInput);

    /**
     * pop digits from stack
     *
     * @return digital output
     */
    BigDecimal popDigital();

    /**
     * set OperationRecord into the rpnCalculator operationRecord
     *
     * @param record Operation record
     */
    void setOperationRecord(Operation record);

    /**
     * get OperationRecord from rpnCalculator
     *
     * @return operation Record
     */
    Operation getOperationRecord();

    /**
     * get OperationRecord from rpnCalculator
     *
     * @return digital Stack size
     */
    int getDigitsStackSize();
}
