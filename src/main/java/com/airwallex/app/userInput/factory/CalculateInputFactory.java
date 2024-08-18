package com.airwallex.app.userInput.factory;

import com.airwallex.app.impl.DefaultCalculateImpl;
import com.airwallex.app.impl.DefaultUserInputImpl;

import java.io.InputStream;

public class CalculateInputFactory {

    public static DefaultUserInputImpl getUserInputFromCommandLine(InputStream input){
        if (null == input) {
            System.err.println("InputStream is null");
        }
        return new DefaultUserInputImpl(input);
    }

    public static DefaultCalculateImpl getDefaultCalculateFromCommandLine(){
        return new DefaultCalculateImpl();
    }
}
