package com.kodilla.testing.forum.statistics;

public class StatisticsPresenter {
    private Statistics statistics;
    private Integer userNo = 0;
    private Integer postsNo = 0;
    private Integer comentsNo = 0;
    private Double meanPostsPerUser = 0.0;
    private Double meanCommentsPerUser = 0.0;
    private Double meanCommentsPerPost = 0.0;

    //aczkolwiek w realnym życiu niezbedny, @InjectMock używa mechanizmu refleksji(taki hack), wiec w tym przypadku zadziała nawet bez tego konstruktora
    public StatisticsPresenter(Statistics statistics) {
        this.statistics = statistics;
    }

    public void calculateAdvStatistics() {
        if (statistics != null) {
            if (statistics.usersNames() != null) {
                userNo = statistics.usersNames().size();
            } else {
                userNo = 0;
            }
            postsNo = statistics.postsCount();
            comentsNo = statistics.commentsCount();
            if (userNo != 0) {
                meanPostsPerUser = (double) postsNo / userNo;
                meanCommentsPerUser = (double) comentsNo / userNo;
            } else {
                meanCommentsPerUser = 0.0;
                meanPostsPerUser = 0.0;
            }
            if (postsNo != 0) {
                meanCommentsPerPost = (double) comentsNo / postsNo;
            } else {
                meanCommentsPerPost = 0.0;
            }
        } else {
            userNo = 0;
            postsNo = 0;
            comentsNo = 0;
            meanPostsPerUser = 0.0;
            meanCommentsPerUser = 0.0;
            meanCommentsPerPost = 0.0;
        }
    }

    public void ShowStatistics() {
        System.out.println("Forum statistics:");
        System.out.println("Users count: " + userNo);
        System.out.println("Posts count:" + postsNo);
        System.out.println("Comments count: " + comentsNo);
        System.out.println("Average posts per user: " + String.format("%.2f", meanPostsPerUser));
        System.out.println("Average comments per user: " + String.format("%.2f", meanCommentsPerUser));
        System.out.println("Average comments per post: " + String.format("%.2f", meanCommentsPerPost));
    }

    public Double getMeanPostsPerUser() {
        return meanPostsPerUser;
    }

    public Double getMeanCommentsPerUser() {
        return meanCommentsPerUser;
    }

    public Double getMeanCommentsPerPost() {
        return meanCommentsPerPost;
    }
}
