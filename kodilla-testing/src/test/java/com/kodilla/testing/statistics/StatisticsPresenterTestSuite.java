package com.kodilla.testing.statistics;

import com.kodilla.testing.forum.statistics.Statistics;
import com.kodilla.testing.forum.statistics.StatisticsPresenter;
import org.junit.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.mockito.Mockito.when;

public class StatisticsPresenterTestSuite {

    //to nie jest blad tylko chcialem ci pokazac ze czesto pojawiajace sie wartosci w testach powinno sie trzymac w stałych
    private static final Double EXPECTED_DOUBLE_ZERO = 0.0;
    private static final Double EXPECTED_DOUBLE_ONE = 1.0;
    private static final Double EXPECTED_DOUBLE_TWO = 2.0;

    @Mock
    private Statistics StatisticMock;

    @InjectMocks
    private StatisticsPresenter statisticsPresenter;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("Starting tests for: " + StatisticsPresenter.class);
    }

    @AfterClass
    public static void afterAllTest() {
        System.out.println("Tests finished, class: " + StatisticsPresenter.class);
    }

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCalculateAdvStatisticsRandValues() {
        //Given
        when(StatisticMock.usersNames()).thenReturn(generateRandomUsers(5));
        when(StatisticMock.commentsCount()).thenReturn(10);
        when(StatisticMock.postsCount()).thenReturn(5);

        //When
        statisticsPresenter.calculateAdvStatistics();

        //Then
        Assert.assertEquals(EXPECTED_DOUBLE_TWO, statisticsPresenter.getMeanCommentsPerUser());
        Assert.assertEquals(EXPECTED_DOUBLE_ONE, statisticsPresenter.getMeanPostsPerUser());
        Assert.assertEquals(EXPECTED_DOUBLE_TWO, statisticsPresenter.getMeanCommentsPerPost());
    }

    @Test
    public void testCalculateAdvStatisticsAllZeros() {
        //Given
        when(StatisticMock.usersNames()).thenReturn(generateRandomUsers(0));
        when(StatisticMock.commentsCount()).thenReturn(0);
        when(StatisticMock.postsCount()).thenReturn(0);

        //When
        statisticsPresenter.calculateAdvStatistics();

        //Then
        Assert.assertEquals(EXPECTED_DOUBLE_ZERO, statisticsPresenter.getMeanCommentsPerUser());
        Assert.assertEquals(EXPECTED_DOUBLE_ZERO, statisticsPresenter.getMeanPostsPerUser());
        Assert.assertEquals(EXPECTED_DOUBLE_ZERO, statisticsPresenter.getMeanCommentsPerPost());
    }

    @Test
    public void testCalculateAdvStatisticsCommentsZero() {
        //Given
        when(StatisticMock.usersNames()).thenReturn(generateRandomUsers(5));
        when(StatisticMock.commentsCount()).thenReturn(0);
        when(StatisticMock.postsCount()).thenReturn(5);

        //When
        statisticsPresenter.calculateAdvStatistics();

        //Then
        Assert.assertEquals(EXPECTED_DOUBLE_ZERO, statisticsPresenter.getMeanCommentsPerUser());
        Assert.assertEquals(EXPECTED_DOUBLE_ONE, statisticsPresenter.getMeanPostsPerUser());
        Assert.assertEquals(EXPECTED_DOUBLE_ZERO, statisticsPresenter.getMeanCommentsPerPost());
    }

    @Test
    public void testCalculateAdvStatisticsPostsZero() {
        //Given        
        when(StatisticMock.usersNames()).thenReturn(generateRandomUsers(5));
        when(StatisticMock.commentsCount()).thenReturn(5);
        when(StatisticMock.postsCount()).thenReturn(0);

        //When
        statisticsPresenter.calculateAdvStatistics();

        //Then
        Assert.assertEquals(EXPECTED_DOUBLE_ONE, statisticsPresenter.getMeanCommentsPerUser());
        Assert.assertEquals(EXPECTED_DOUBLE_ZERO, statisticsPresenter.getMeanPostsPerUser());
        Assert.assertEquals(EXPECTED_DOUBLE_ZERO, statisticsPresenter.getMeanCommentsPerPost());
    }

    @Test
    public void testCalculateAdvStatisticsUsersZero() {
        //Given        
        when(StatisticMock.usersNames()).thenReturn(generateRandomUsers(0));
        when(StatisticMock.commentsCount()).thenReturn(10);
        when(StatisticMock.postsCount()).thenReturn(5);

        //When
        statisticsPresenter.calculateAdvStatistics();

        //Then
        Assert.assertEquals(EXPECTED_DOUBLE_ZERO, statisticsPresenter.getMeanCommentsPerUser());
        Assert.assertEquals(EXPECTED_DOUBLE_ZERO, statisticsPresenter.getMeanPostsPerUser());
        Assert.assertEquals(EXPECTED_DOUBLE_TWO, statisticsPresenter.getMeanCommentsPerPost());
    }

    @Test
    public void testCalculateAdvStatisticsPosts1000() {
        //Given        
        when(StatisticMock.usersNames()).thenReturn(generateRandomUsers(10));
        when(StatisticMock.commentsCount()).thenReturn(20);
        when(StatisticMock.postsCount()).thenReturn(1000);

        //When
        statisticsPresenter.calculateAdvStatistics();

        //Then
        Assert.assertEquals(EXPECTED_DOUBLE_TWO, statisticsPresenter.getMeanCommentsPerUser());
        Assert.assertEquals((Double) 100.0, statisticsPresenter.getMeanPostsPerUser());
        Assert.assertEquals((Double) 0.02, statisticsPresenter.getMeanCommentsPerPost());
    }

    @Test
    public void testCalculateAdvStatisticsUsers100() {
        //Given        
        when(StatisticMock.usersNames()).thenReturn(generateRandomUsers(100));
        when(StatisticMock.commentsCount()).thenReturn(20);
        when(StatisticMock.postsCount()).thenReturn(10);

        //When
        statisticsPresenter.calculateAdvStatistics();

        //Then
        Assert.assertEquals((Double) 0.2, statisticsPresenter.getMeanCommentsPerUser());
        Assert.assertEquals((Double) 0.1, statisticsPresenter.getMeanPostsPerUser());
        Assert.assertEquals(EXPECTED_DOUBLE_TWO, statisticsPresenter.getMeanCommentsPerPost());
    }

    @Test
    public void testCalculateAdvStatisticsCommentOverPosts() {
        //Given        
        when(StatisticMock.usersNames()).thenReturn(generateRandomUsers(100));
        when(StatisticMock.commentsCount()).thenReturn(2000);
        when(StatisticMock.postsCount()).thenReturn(100);

        //When
        statisticsPresenter.calculateAdvStatistics();

        //Then
        Assert.assertEquals((Double) 20.0, statisticsPresenter.getMeanCommentsPerUser());
        Assert.assertEquals(EXPECTED_DOUBLE_ONE, statisticsPresenter.getMeanPostsPerUser());
        Assert.assertEquals((Double) 20.0, statisticsPresenter.getMeanCommentsPerPost());
    }

    @Test
    public void testCalculateAdvStatisticsPostsOverComments() {
        //Given        
        when(StatisticMock.usersNames()).thenReturn(generateRandomUsers(100));
        when(StatisticMock.commentsCount()).thenReturn(2000);
        when(StatisticMock.postsCount()).thenReturn(5000);

        //When
        statisticsPresenter.calculateAdvStatistics();

        //Then
        Assert.assertEquals((Double) 20.0, statisticsPresenter.getMeanCommentsPerUser());
        Assert.assertEquals((Double) 50.0, statisticsPresenter.getMeanPostsPerUser());
        Assert.assertEquals((Double) 0.4, statisticsPresenter.getMeanCommentsPerPost());
    }

    @Test
    public void testCalculateAdvStatisticsNullUserList() {
        //Given
        when(StatisticMock.usersNames()).thenReturn(null);
        when(StatisticMock.commentsCount()).thenReturn(2000);
        when(StatisticMock.postsCount()).thenReturn(5000);

        //When
        statisticsPresenter.calculateAdvStatistics();

        //Then
        Assert.assertEquals(EXPECTED_DOUBLE_ZERO, statisticsPresenter.getMeanCommentsPerUser());
        Assert.assertEquals(EXPECTED_DOUBLE_ZERO, statisticsPresenter.getMeanPostsPerUser());
        Assert.assertEquals((Double) 0.4, statisticsPresenter.getMeanCommentsPerPost());
    }

    @Test
    public void testCalculateAdvStatisticsBIG() {
        //Given
        when(StatisticMock.usersNames()).thenReturn(generateRandomUsers(1000000));
        when(StatisticMock.commentsCount()).thenReturn(10000000);
        when(StatisticMock.postsCount()).thenReturn(10000000);

        //When
        statisticsPresenter.calculateAdvStatistics();

        //Then
        Assert.assertEquals((Double) 10.0, statisticsPresenter.getMeanCommentsPerUser());
        Assert.assertEquals((Double) 10.0, statisticsPresenter.getMeanPostsPerUser());
        Assert.assertEquals(EXPECTED_DOUBLE_ONE, statisticsPresenter.getMeanCommentsPerPost());
    }

    //private na koncu
    private List<String> generateRandomUsers(int usersNo) {
        //mozna skrocic
        return IntStream.range(0, usersNo).mapToObj(i -> "User" + i).collect(Collectors.toList());
    }
}
