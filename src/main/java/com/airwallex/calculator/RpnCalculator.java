package com.airwallex.calculator;

import com.airwallex.calculator.api.Calculate;
import com.airwallex.calculator.api.UserInput;
import com.airwallex.calculator.operate.factory.CalculateInputFactory;
import com.airwallex.calculator.operate.AbstractOperator;
import com.airwallex.calculator.utils.CalculatorUtils;

import java.util.EmptyStackException;
import java.util.List;

public class RpnCalculator {

    private UserInput userInput;

    private Calculate calculate;

    public RpnCalculator() {
        //construct SystemInput
        this.userInput = CalculateInputFactory.getUserInputFromCommandLine(System.in);
        this.calculate = CalculateInputFactory.getDefaultCalculateFromCommandLine();
    }


    public void execute() {
        List<AbstractOperator> userInputs = null;
        int count = 1;
        while (null != (userInputs = this.userInput.getUserInput())) {
            for (AbstractOperator operator : userInputs) {
                try {
                    operator.calculate(this.calculate);
                    count+=2;
                } catch (EmptyStackException ese) {
                    System.err.println(CalculatorUtils.printEmptyStackErrorMessage(operator.getOperatorName(), count));
                    break;
                }
            }
            CalculatorUtils.printStack(this.calculate.getDigitStack());
        }
    }


    public static void main(String[] argv) {
        RpnCalculator rpnCalculator = new RpnCalculator();
        rpnCalculator.execute();
    }
}
