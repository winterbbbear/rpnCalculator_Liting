package com.airwallex.app;

import com.airwallex.app.api.Calculate;
import com.airwallex.app.api.UserInput;
import com.airwallex.app.impl.DefaultCalculateImpl;
import com.airwallex.app.impl.DefaultUserInputImpl;
import com.airwallex.app.userEnter.operator.AbstractOperator;
import com.airwallex.app.utils.CalculatorUtils;

import java.io.InputStream;
import java.util.EmptyStackException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class RpnCalculator {

    private UserInput userInput;

    private Calculate calculate;

    public RpnCalculator() {
        this(System.in);
    }

    public RpnCalculator(InputStream input) {
        if (null == input) {
            throw new IllegalArgumentException("InputStream cannot be null!");
        }
        this.userInput = new DefaultUserInputImpl(input);
        this.calculate = new DefaultCalculateImpl();
    }

    public void execute() {
        List<AbstractOperator> userEntries = null;
        AtomicInteger counter = new AtomicInteger(1);
        while (null != (userEntries = this.userInput.getUserInput())) {
            for (AbstractOperator operator : userEntries) {
                try {
                    operator.calculate(this.calculate);
                    counter.incrementAndGet();
                } catch (EmptyStackException ese) {
                    System.err.println(CalculatorUtils.printEmptyStackErrorMessage(operator.getOperatorName(), counter.get()));
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
