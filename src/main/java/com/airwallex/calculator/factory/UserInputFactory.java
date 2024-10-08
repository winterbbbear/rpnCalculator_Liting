package com.airwallex.calculator.factory;

import com.airwallex.calculator.error.OperatorErrorCode;
import com.airwallex.calculator.impl.DefaultUserInputImpl;

import java.io.InputStream;

public class UserInputFactory {

    public static DefaultUserInputImpl getUserInputFromCommandLine(InputStream input){
        if (null == input) {
            System.err.println(OperatorErrorCode.ILLEGAL_ARGUMENT.getDescription());
        }
        return new DefaultUserInputImpl(input);
    }
}
