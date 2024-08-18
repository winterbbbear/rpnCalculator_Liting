package com.airwallex.app.api;

import com.airwallex.app.record.OperationRecord;

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

    void setOperationRecord(OperationRecord record);

    OperationRecord getOperationRecord();

    int getDigitsStackSize();
}
