package com.airwallex.calculator;

import com.airwallex.calculator.api.Calculate;
import com.airwallex.calculator.api.UserInput;
import com.airwallex.calculator.factory.CalculatorFactory;
import com.airwallex.calculator.factory.UserInputFactory;
import com.airwallex.calculator.operate.AbstractOperator;
import com.airwallex.calculator.operate.function.ClearOperator;
import com.airwallex.calculator.utils.CalculatorUtils;

import java.util.EmptyStackException;
import java.util.List;

/**
 * Main class of RpnCalculator
 *
 * @author litingsheng
 * @date 2024/08/21
 */
public class RpnCalculator {

    private UserInput userInput;

    private Calculate calculate;

    public RpnCalculator() {
        //0.construct SystemInput
        this.userInput = UserInputFactory.getUserInputFromCommandLine(System.in);
        this.calculate = CalculatorFactory.getDefaultCalculator();
    }

    public void execute() {
        List<AbstractOperator> userInputs = null;
        userInput.resetScannerPosition();
        while (null != (userInputs = this.userInput.getUserInput())) {
            for (AbstractOperator operator: userInputs) {
                try {
                    operator.calculate(this.calculate);
                    userInput.increaseScannerPosition(2);
                    if (operator instanceof ClearOperator) {
                        //clear operator should reset the scanner position
                        userInput.resetScannerPosition();
                    }
                } catch (EmptyStackException ese) {
                    System.err.println(CalculatorUtils.printEmptyStackErrorMessage(operator.getOperatorName(), userInput.getScannerPosition()));
                    break;
                }
            }
            calculate.printStack();
        }
    }

    public static void main(String[] argv) {
        RpnCalculator rpnCalculator = new RpnCalculator();
        rpnCalculator.execute();
    }
}
