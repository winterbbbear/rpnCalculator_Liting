package com.airwallex.calculator.impl;

import com.airwallex.calculator.operate.AbstractOperator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Optional;


@RunWith(PowerMockRunner.class)
public class DefaultUserInputImplTest {

    private DefaultUserInputImpl defaultCalculateImpl = new DefaultUserInputImpl(new ByteArrayInputStream("input".getBytes()));

    @Test
    public void testGetUserInput() {
        List<AbstractOperator> userInput = defaultCalculateImpl.getUserInput();
        Assert.assertNotNull(userInput);
    }

    @Test
    public void testConstructUserInputWithDigitalInput() {
        final Optional<AbstractOperator> result = defaultCalculateImpl.constructUserInput("1");

        AbstractOperator abstractOperator = result.get();
        Assert.assertNotNull(abstractOperator);
    }

    @Test
    public void testConstructUserInputWithOperatorInput() {
        Optional<AbstractOperator> result = defaultCalculateImpl.constructUserInput("+");

        AbstractOperator abstractOperator = result.get();
        Assert.assertNotNull(abstractOperator);
    }

    @Test
    public void testIncreaseScannerPositionWithReset(){
        defaultCalculateImpl.resetScannerPosition();
        defaultCalculateImpl.increaseScannerPosition(2);
        Assert.assertEquals(defaultCalculateImpl.getScannerPosition(),3);
    }

    @Test
    public void testResetScannerPosition(){
        defaultCalculateImpl.resetScannerPosition();
        Assert.assertEquals(defaultCalculateImpl.getScannerPosition(),1);
    }
}
