package com.airwallex.app.impl;

import com.airwallex.calculator.impl.DefaultUserInputImpl;
import com.airwallex.calculator.operate.digital.DigitalOperator;
import com.airwallex.calculator.operate.AbstractOperator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;


@RunWith(PowerMockRunner.class)
public class DefaultUserInputImplTest {

    private DefaultUserInputImpl defaultUserInput;

    @Before
    public void setUp() {
        InputStream input = new InputStream() {
            @Override
            public int read() throws IOException {
                return 0;
            }
        };
        this.defaultUserInput = new DefaultUserInputImpl(input);
    }

    @Test
    public void testGetOperatorUserEntryWithNullInput() {
        Optional<AbstractOperator> nonInput = defaultUserInput.getOperatorUserInput(null);
        Assert.assertFalse(nonInput.isPresent());
    }

    @Test
    public void testGetDigitalUserEntryWithNullInput() {
        AbstractOperator abstractOperator = defaultUserInput.getDigitalUserInput(null);
        Assert.assertNull(abstractOperator);
    }

    @Test
    public void testGetDigitalUserEntryWithDigitalInput() {
        AbstractOperator abstractOperator = defaultUserInput.getDigitalUserInput("5");
        Assert.assertNotNull(abstractOperator);
        Assert.assertTrue(abstractOperator instanceof DigitalOperator);
    }
}