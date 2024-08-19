package com.airwallex.calculator.operate.factory;

import com.airwallex.calculator.error.OperatorErrorCode;
import com.airwallex.calculator.impl.DefaultCalculateImpl;
import com.airwallex.calculator.impl.DefaultUserInputImpl;

import java.io.InputStream;

public class CalculateInputFactory {

    public static DefaultUserInputImpl getUserInputFromCommandLine(InputStream input){
        if (null == input) {
            System.err.println(OperatorErrorCode.ILLEGAL_ARGUMENT.getCode());
        }
        return new DefaultUserInputImpl(input);
    }

    public static DefaultCalculateImpl getDefaultCalculateFromCommandLine(){
        return new DefaultCalculateImpl();
    }
}
