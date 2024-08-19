package com.airwallex.app;

import com.airwallex.calculator.RpnCalculator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.IOException;
import java.io.InputStream;


@RunWith(PowerMockRunner.class)
public class RpnCalculatorTest {

    @InjectMocks
    private RpnCalculator rpnCalculator;

    @Test
    public void testRpnCalculatorWithIllegalInput() throws Throwable {
        InputStream in = new InputStream() {
            @Override
            public int read() throws IOException {
                return 1;
            }
        };
        RpnCalculator rpnCalculator = new RpnCalculator();
        Assert.assertNotNull(rpnCalculator);
    }
}