package com.airwallex.calculator.factory;

import com.airwallex.calculator.impl.DefaultCalculateImpl;

/**
 * CalculatorFactory to construct all types of calculator
 *
 * @author litingsheng
 * @date 2024/08/20
 */
public class CalculatorFactory {

    public static DefaultCalculateImpl getDefaultCalculator(){
        return new DefaultCalculateImpl();
    }
}
