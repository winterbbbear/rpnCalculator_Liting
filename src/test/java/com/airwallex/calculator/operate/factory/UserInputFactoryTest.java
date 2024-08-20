package com.airwallex.calculator.operate.factory;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@RunWith(PowerMockRunner.class)
public class UserInputFactoryTest {

    private UserInputFactory userInputFactory;

    @Test
    public void getUserInputFromCommandLineWithIllegalInput() {
        InputStream inputStream = new ByteArrayInputStream("input".getBytes());
        UserInputFactory.getUserInputFromCommandLine(inputStream);
        Assert.assertNotNull(UserInputFactory.getUserInputFromCommandLine(inputStream).getUserInput());
    }
}