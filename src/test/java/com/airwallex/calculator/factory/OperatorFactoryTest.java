package com.airwallex.calculator.factory;

import com.airwallex.calculator.operate.AbstractOperator;
import com.airwallex.calculator.operate.math.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Optional;

import static org.junit.Assert.*;

/**
 * Test class of OperatorFactory
 *
 * @author litingsheng
 * @date 2024/08/21
 */
@RunWith(PowerMockRunner.class)
public class OperatorFactoryTest {

    @InjectMocks
    private OperatorFactory operatorFactory;

    /**
     * Given an addition string
     * When the getOperator method called
     * Then the addition operator should return
     */
    @Test
    public void testAdditionOperatorFromFactory() {
        String userEntered = "+";
        Optional<AbstractOperator> userEntry = OperatorFactory.getOperator(userEntered);
        assertNotNull(userEntry);
        assertTrue(userEntry.isPresent());
        assertTrue(userEntry.get() instanceof AdditionOperator);
    }

    /**
     * Given a subtraction string
     * When the getOperator method called
     * Then the subtraction operator should return
     */
    @Test
    public void testSubtractionOperatorFromFactory() {
        String userEntered = "-";
        Optional<AbstractOperator> userEntry = OperatorFactory.getOperator(userEntered);
        assertNotNull(userEntry);
        assertTrue(userEntry.isPresent());
        assertTrue(userEntry.get() instanceof SubtractionOperator);
    }

    /**
     * Given a multiplication string
     * When the getOperator method called
     * Then the multiplication operator should return
     */
    @Test
    public void testMultiplicationOperatorFromFactory() {
        String userEntered = "*";
        Optional<AbstractOperator> userEntry = OperatorFactory.getOperator(userEntered);
        assertNotNull(userEntry);
        assertTrue(userEntry.isPresent());
        assertTrue(userEntry.get() instanceof MultiplicationOperator);
    }

    /**
     * Given a sqrt string
     * When the getOperator method called
     * Then the SquareRoot operator should return
     */
    @Test
    public void testSquareRootOperatorFromFactory() {
        String userEntered = "sqrt";
        Optional<AbstractOperator> userEntry = OperatorFactory.getOperator(userEntered);
        assertNotNull(userEntry);
        assertTrue(userEntry.isPresent());
        assertTrue(userEntry.get() instanceof SquareRootOperator);
    }

    /**
     * Given a Division string
     * When the getOperator method called
     * Then the Division operator should return
     */
    @Test
    public void testDivisionOperatorFromFactory() {
        String userEntered = "/";
        Optional<AbstractOperator> userEntry = OperatorFactory.getOperator(userEntered);
        assertNotNull(userEntry);
        assertTrue(userEntry.isPresent());
        assertTrue(userEntry.get() instanceof DivisionOperator);
    }

}