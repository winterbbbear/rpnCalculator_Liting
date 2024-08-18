package com.airwallex.app.utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CalculatorUtils {

    private static final String SPACE = " ";

    private static final int ZERO = 0;

    private static final int TEN = 10;

    public static void printStack(Stack<BigDecimal> digitStack) {
        System.out.print("stack: ");
        List<BigDecimal> elements = new ArrayList<>(digitStack);
        elements.forEach(e -> {
            System.out.print((ZERO == e.scale()) ? e : format10Digits(e.stripTrailingZeros()));
            System.out.print(SPACE);
        });

        System.out.println();
    }

    public static String printEmptyStackErrorMessage(String operator, int counter) {
        String stringBuilder = "Operator: " + operator +
                " (position: " +
                counter +
                "): insufficient parameters";
        return stringBuilder;
    }

    private static String format10Digits(BigDecimal digit) {
        if (TEN <= digit.scale()) {
            return String.format("%.10f", digit.floatValue());
        } else {
            return digit.toString();
        }
    }
}
