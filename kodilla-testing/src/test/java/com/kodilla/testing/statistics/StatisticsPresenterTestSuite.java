package com.kodilla.testing.statistics;

import com.kodilla.testing.forum.statistics.Statistics;
import com.kodilla.testing.forum.statistics.StatisticsPresenter;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StatisticsPresenterTestSuite {

    private List<String> generateRandomUsers(int usersNo){
        List<String> users = new ArrayList<>();

        for(int i=0;i<usersNo;i++){
            users.add("User"+i+1);
        }
        return users;
    }

    @BeforeClass
    public static void beforeAllTests(){
        System.out.println("Starting tests for: " + StatisticsPresenter.class);
    }

    @AfterClass
    public static void afterAllTest(){
        System.out.println("Tests finished, class: "+ StatisticsPresenter.class);
    }

    @Test
    public void testCalculateAdvStatisticsRandValues(){
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        when(statisticsMock.usersNames()).thenReturn(generateRandomUsers(5));
        when(statisticsMock.commentsCount()).thenReturn(10);
        when(statisticsMock.postsCount()).thenReturn(5);

        StatisticsPresenter presenter = new StatisticsPresenter();

        //When
        presenter.calculateAdvStatistics(statisticsMock);

        //Then
        Assert.assertEquals((Double)2.0,presenter.getMeanCommentsPerUser());
        Assert.assertEquals((Double)1.0,presenter.getMeanPostsPerUser());
        Assert.assertEquals((Double)2.0,presenter.getMeanCommentsPerPost());
    }

    @Test
    public void testCalculateAdvStatisticsAllZeros(){
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        when(statisticsMock.usersNames()).thenReturn(generateRandomUsers(0));
        when(statisticsMock.commentsCount()).thenReturn(0);
        when(statisticsMock.postsCount()).thenReturn(0);

        StatisticsPresenter presenter = new StatisticsPresenter();

        //When
        presenter.calculateAdvStatistics(statisticsMock);

        //Then
        Assert.assertEquals((Double)0.0,presenter.getMeanCommentsPerUser());
        Assert.assertEquals((Double)0.0,presenter.getMeanPostsPerUser());
        Assert.assertEquals((Double)0.0,presenter.getMeanCommentsPerPost());
    }

    @Test
    public void testCalculateAdvStatisticsCommentsZero(){
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        when(statisticsMock.usersNames()).thenReturn(generateRandomUsers(5));
        when(statisticsMock.commentsCount()).thenReturn(0);
        when(statisticsMock.postsCount()).thenReturn(5);

        StatisticsPresenter presenter = new StatisticsPresenter();

        //When
        presenter.calculateAdvStatistics(statisticsMock);

        //Then
        Assert.assertEquals((Double)0.0,presenter.getMeanCommentsPerUser());
        Assert.assertEquals((Double)1.0,presenter.getMeanPostsPerUser());
        Assert.assertEquals((Double)0.0,presenter.getMeanCommentsPerPost());
    }

    @Test
    public void testCalculateAdvStatisticsPostsZero(){
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        when(statisticsMock.usersNames()).thenReturn(generateRandomUsers(5));
        when(statisticsMock.commentsCount()).thenReturn(5);
        when(statisticsMock.postsCount()).thenReturn(0);

        StatisticsPresenter presenter = new StatisticsPresenter();

        //When
        presenter.calculateAdvStatistics(statisticsMock);

        //Then
        Assert.assertEquals((Double)1.0,presenter.getMeanCommentsPerUser());
        Assert.assertEquals((Double)0.0,presenter.getMeanPostsPerUser());
        Assert.assertEquals((Double)0.0,presenter.getMeanCommentsPerPost());
    }

    @Test
    public void testCalculateAdvStatisticsUsersZero(){
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        when(statisticsMock.usersNames()).thenReturn(generateRandomUsers(0));
        when(statisticsMock.commentsCount()).thenReturn(10);
        when(statisticsMock.postsCount()).thenReturn(5);

        StatisticsPresenter presenter = new StatisticsPresenter();

        //When
        presenter.calculateAdvStatistics(statisticsMock);

        //Then
        Assert.assertEquals((Double)0.0,presenter.getMeanCommentsPerUser());
        Assert.assertEquals((Double)0.0,presenter.getMeanPostsPerUser());
        Assert.assertEquals((Double)2.0,presenter.getMeanCommentsPerPost());
    }

    @Test
    public void testCalculateAdvStatisticsPosts1000(){
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        when(statisticsMock.usersNames()).thenReturn(generateRandomUsers(10));
        when(statisticsMock.commentsCount()).thenReturn(20);
        when(statisticsMock.postsCount()).thenReturn(1000);

        StatisticsPresenter presenter = new StatisticsPresenter();

        //When
        presenter.calculateAdvStatistics(statisticsMock);

        //Then
        Assert.assertEquals((Double)2.0,presenter.getMeanCommentsPerUser());
        Assert.assertEquals((Double)100.0,presenter.getMeanPostsPerUser());
        Assert.assertEquals((Double)0.02,presenter.getMeanCommentsPerPost());
    }

    @Test
    public void testCalculateAdvStatisticsUsers100(){
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        when(statisticsMock.usersNames()).thenReturn(generateRandomUsers(100));
        when(statisticsMock.commentsCount()).thenReturn(20);
        when(statisticsMock.postsCount()).thenReturn(10);

        StatisticsPresenter presenter = new StatisticsPresenter();

        //When
        presenter.calculateAdvStatistics(statisticsMock);

        //Then
        Assert.assertEquals((Double)0.2,presenter.getMeanCommentsPerUser());
        Assert.assertEquals((Double)0.1,presenter.getMeanPostsPerUser());
        Assert.assertEquals((Double)2.0,presenter.getMeanCommentsPerPost());
    }

    @Test
    public void testCalculateAdvStatisticsCommentOverPosts(){
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        when(statisticsMock.usersNames()).thenReturn(generateRandomUsers(100));
        when(statisticsMock.commentsCount()).thenReturn(2000);
        when(statisticsMock.postsCount()).thenReturn(100);

        StatisticsPresenter presenter = new StatisticsPresenter();

        //When
        presenter.calculateAdvStatistics(statisticsMock);

        //Then
        Assert.assertEquals((Double)20.0,presenter.getMeanCommentsPerUser());
        Assert.assertEquals((Double)1.0,presenter.getMeanPostsPerUser());
        Assert.assertEquals((Double)20.0,presenter.getMeanCommentsPerPost());
    }

    @Test
    public void testCalculateAdvStatisticsPostsOverComments(){
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        when(statisticsMock.usersNames()).thenReturn(generateRandomUsers(100));
        when(statisticsMock.commentsCount()).thenReturn(2000);
        when(statisticsMock.postsCount()).thenReturn(5000);

        StatisticsPresenter presenter = new StatisticsPresenter();

        //When
        presenter.calculateAdvStatistics(statisticsMock);

        //Then
        Assert.assertEquals((Double)20.0,presenter.getMeanCommentsPerUser());
        Assert.assertEquals((Double)50.0,presenter.getMeanPostsPerUser());
        Assert.assertEquals((Double)0.4,presenter.getMeanCommentsPerPost());
    }

    @Test
    public void testCalculateAdvStatisticsNullUserList(){
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        when(statisticsMock.usersNames()).thenReturn(null);
        when(statisticsMock.commentsCount()).thenReturn(2000);
        when(statisticsMock.postsCount()).thenReturn(5000);

        StatisticsPresenter presenter = new StatisticsPresenter();

        //When
        presenter.calculateAdvStatistics(statisticsMock);

        //Then
        Assert.assertEquals((Double)0.0,presenter.getMeanCommentsPerUser());
        Assert.assertEquals((Double)0.0,presenter.getMeanPostsPerUser());
        Assert.assertEquals((Double)0.4,presenter.getMeanCommentsPerPost());
    }

    @Test
    public void testCalculateAdvStatisticsBIG(){
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        when(statisticsMock.usersNames()).thenReturn(generateRandomUsers(1000000));
        when(statisticsMock.commentsCount()).thenReturn(10000000);
        when(statisticsMock.postsCount()).thenReturn(10000000);

        StatisticsPresenter presenter = new StatisticsPresenter();

        //When
        presenter.calculateAdvStatistics(statisticsMock);

        //Then
        Assert.assertEquals((Double)10.0,presenter.getMeanCommentsPerUser());
        Assert.assertEquals((Double)10.0,presenter.getMeanPostsPerUser());
        Assert.assertEquals((Double)1.0,presenter.getMeanCommentsPerPost());
    }
}
