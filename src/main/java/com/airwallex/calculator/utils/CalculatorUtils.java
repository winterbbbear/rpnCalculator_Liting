package com.airwallex.calculator.utils;


/**
 * CalculatorUtils to process the format of output information
 *
 * @author litingsheng
 * @date 2024/08/21
 */
public class CalculatorUtils {

    public static String printEmptyStackErrorMessage(String operator, int counter) {
        String stringBuilder = "operator: " + operator +
                " (position: " +
                counter +
                "): insufficient parameters";
        return stringBuilder;
    }
}
