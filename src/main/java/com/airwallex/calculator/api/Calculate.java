package com.airwallex.calculator.api;

import com.airwallex.calculator.operate.record.Operation;

import java.math.BigDecimal;
import java.util.Stack;

/**
  * calculate implements using stacks
  * @author litingsheng
 */
public interface Calculate {

    /**
     * get digital from operation stack
     */
    Stack<BigDecimal> getDigitStack();

    /**
     * push digital and store the digital into operation record
     */
    void pushDigital(BigDecimal userInput);

    /**
     * pop digital from stack
     */
    BigDecimal popDigital();

    /**
     * set OperationRecord into the rpnCalculator operationRecord
     */
    void setOperationRecord(Operation record);

    /**
     * calculate implements using stacks
     */
    Operation getOperationRecord();

    /**
     * calculate implements using stacks
     */
    int getDigitsStackSize();
}
