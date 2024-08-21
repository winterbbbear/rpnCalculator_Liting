package com.airwallex.calculator.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
