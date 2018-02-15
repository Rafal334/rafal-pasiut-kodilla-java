package com.kodilla.patterns2.observer.forum;

public class ForumUser implements Observer {

    private final String userName;
    private int updateCount;

    public ForumUser(String userName) {
        this.userName = userName;
    }

    @Override
    public void update(ForumTopic forumTopic) {
        System.out.println(userName + ": New messages in topic " + forumTopic.getName() +
                " (total: " + forumTopic.getMessages().size() + " messages)");
        updateCount++;
    }

    public String getUserName() {
        return userName;
    }

    public int getUpdateCount() {
        return updateCount;
    }
}
