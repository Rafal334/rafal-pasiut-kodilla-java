package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser {

    private final int userID;
    private final String userName;
    private final char sex;
    private final LocalDate dayOfBirth;
    private final int postsNo;

    public ForumUser(final int userID, final String userName, final char sex, final LocalDate dayOfBirth, final int postsNo) {
        this.userID = userID;
        this.userName = userName;
        this.sex = sex;
        this.dayOfBirth = dayOfBirth;
        this.postsNo = postsNo;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "userID=" + userID +
                ", userName='" + userName + '\'' +
                ", sex=" + sex +
                ", dayOfBirth=" + dayOfBirth +
                ", postsNo=" + postsNo +
                '}';
    }

    public boolean olderThan(int age) {
        LocalDate older = dayOfBirth.plusYears(age);
        return older.isBefore(LocalDate.now());
    }

    public char getSex() {
        return sex;
    }

    public int getUserID() {
        return userID;
    }

    public int getPostsNo() {
        return postsNo;
    }
}
