package com.kodilla.patterns.strategy.social;

import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {

    @Test
    public void testDefaultSharingStrategies() {
        //Given
        User a = new Millenials("Steven");
        User b = new YGeneration("John");
        User c = new ZGeneration("Tom");

        //When
        String aMessage = a.sharePost();
        String bMessage = b.sharePost();
        String cMessage = c.sharePost();

        //Then
        Assert.assertEquals("Sharing on Twitter", aMessage);
        Assert.assertEquals("Sharing on Facebook", bMessage);
        Assert.assertEquals("Sharing on Snapchat", cMessage);
    }

    @Test
    public void testIndividualSharingStrategy() {
        //Given
        User a = new Millenials("Steven");

        //When
        String beforeSet = a.sharePost();
        a.setPublisherService(new FacebookPublisher());
        String afterSet = a.sharePost();

        //Then
        Assert.assertEquals("Sharing on Twitter", beforeSet);
        Assert.assertEquals("Sharing on Facebook", afterSet);
    }
}
