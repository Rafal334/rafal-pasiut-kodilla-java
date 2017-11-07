package com.kodilla.testing.forum;

import com.kodilla.testing.user.SimpleUser;
import org.junit.Assert;
import org.junit.Test;

public class ForumTestSuite {

    @Test
    public void testCaseUsername(){
        //Given
        String testUsername = "theForumUser";
        SimpleUser simpleUser = new SimpleUser(testUsername);

        //When
        String result = simpleUser.getUsername();

        //Then
        Assert.assertEquals(testUsername,result);
    }
}
