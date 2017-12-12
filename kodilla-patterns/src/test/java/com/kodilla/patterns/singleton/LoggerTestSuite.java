package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.Test;

import java.util.stream.IntStream;

public class LoggerTestSuite {

    @Test
    public void testLoggerSimpleLog() {
        //Given
        String logMessage = "Sample log";
        //When
        Logger.getInstance().log(logMessage);
        //Then
        Assert.assertEquals(logMessage, Logger.getInstance().getLastLog());
    }

    @Test
    public void testLoggerFewLogs() {
        //Given
        String logMessage = "Sample log";
        //When
        IntStream.range(0, 10).
                forEach(i -> Logger.getInstance().log(logMessage + i));
        //Then
        Assert.assertEquals(logMessage + "9", Logger.getInstance().getLastLog());
    }
}
