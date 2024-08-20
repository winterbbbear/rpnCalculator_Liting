package com.airwallex.calculator.operate.factory;

import com.airwallex.calculator.operate.AbstractOperator;
import com.airwallex.calculator.operate.math.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
public class OperatorFactoryTest {


    @Test
    public void testAdditionOperatorFromFactory() {
        String userEntered = "+";
        Optional<AbstractOperator> userEntry = OperatorFactory.getOperator(userEntered);
        assertNotNull(userEntry);
        assertTrue(userEntry.isPresent());
        assertTrue(userEntry.get() instanceof AdditionOperator);
    }

    @Test
    public void testSubtractionOperatorFromFactory() {
        String userEntered = "-";
        Optional<AbstractOperator> userEntry = OperatorFactory.getOperator(userEntered);
        assertNotNull(userEntry);
        assertTrue(userEntry.isPresent());
        assertTrue(userEntry.get() instanceof SubtractionOperator);
    }

    @Test
    public void testMultiplicationOperatorFromFactory() {
        String userEntered = "*";
        Optional<AbstractOperator> userEntry = OperatorFactory.getOperator(userEntered);
        assertNotNull(userEntry);
        assertTrue(userEntry.isPresent());
        assertTrue(userEntry.get() instanceof MultiplicationOperator);
    }

    @Test
    public void testSquareRootOperatorFromFactory() {
        String userEntered = "sqrt";
        Optional<AbstractOperator> userEntry = OperatorFactory.getOperator(userEntered);
        assertNotNull(userEntry);
        assertTrue(userEntry.isPresent());
        assertTrue(userEntry.get() instanceof SquareRootOperator);
    }

    @Test
    public void testDivisionOperatorFromFactory() {
        String userEntered = "/";
        Optional<AbstractOperator> userEntry = OperatorFactory.getOperator(userEntered);
        assertNotNull(userEntry);
        assertTrue(userEntry.isPresent());
        assertTrue(userEntry.get() instanceof DivisionOperator);
    }

}