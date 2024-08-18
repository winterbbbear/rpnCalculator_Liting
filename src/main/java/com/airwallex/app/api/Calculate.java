package com.airwallex.app.api;

import com.airwallex.app.userInput.record.Operation;

import java.math.BigDecimal;
import java.util.Stack;

/**
  * calculate using stack
  *
  * @author litingsheng
 */
public interface Calculate {

    Stack<BigDecimal> getDigitStack();

    void pushDigital(BigDecimal userInput);

    BigDecimal popDigital();

    void setOperationRecord(Operation record);

    Operation getOperationRecord();

    int getDigitsStackSize();
}
