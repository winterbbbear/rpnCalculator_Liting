package com.airwallex.calculator.api;

import com.airwallex.calculator.operate.AbstractOperator;

import java.util.List;

/**
 * interface: UserInput from command-line
 *
 * @author litingsheng
 * @date 2024/08/18
 */
public interface UserInput {

    /**
     * read AbstractOperator input
     * (including digital, function and math operators from user input)
     */
    List<AbstractOperator> getUserInput();
}
