package com.airwallex.calculator.factory;

import com.airwallex.calculator.factory.UserInputFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * Test class of UserInputFactory
 *
 * @author litingsheng
 * @date 2024/08/21
 */
@RunWith(PowerMockRunner.class)
public class UserInputFactoryTest {

    @InjectMocks
    private UserInputFactory userInputFactory;

    @Test
    public void getUserInputFromCommandLineWithIllegalInput() {
        InputStream inputStream = new ByteArrayInputStream("input".getBytes());
        UserInputFactory.getUserInputFromCommandLine(inputStream);
        Assert.assertNotNull(UserInputFactory.getUserInputFromCommandLine(inputStream).getUserInput());
    }
}