package com.airwallex.calculator.error;

/**
 * detailed operatorErrorCode
 *
 * @author litingsheng
 * @date 2024/08/20
 */
public class OperatorErrorCode {

    /**
     * Illegal Argument Error Code
     */
    public static final ErrorCode ILLEGAL_ARGUMENT = new ErrorCode("10001", "The input is Illegal");

    /**
     * Zero Divisor Error in Division Operator
     */
    public static final ErrorCode ZERO_DIVISOR = new ErrorCode("10002", "the divisor cannot be zero");

    /**
     * Empty Input Error Code
     */
    public static final ErrorCode EMPTY_INPUT = new ErrorCode("10003", "The input is Empty");

    /**
     * Square root Error Code
     */
    public static final ErrorCode SQUARE_ROOT_ERROR = new ErrorCode("10004", "Square root can not be negative");
}
