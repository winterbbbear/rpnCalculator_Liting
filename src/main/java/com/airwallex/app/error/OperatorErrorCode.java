package com.airwallex.app.error;

import com.airwallex.app.error.ErrorCode;

public class OperatorErrorCode {

    public static final ErrorCode ILLEGAL_ARGUMENT = new ErrorCode("10001", "The input is Illegal");

    public static final ErrorCode ZERO_DIVISOR = new ErrorCode("10001", "the divisor cannot be zero");

}
