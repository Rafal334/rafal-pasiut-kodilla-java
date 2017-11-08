package com.kodilla.testing.forum;

public class ForumPost {
    String postBody;
    String author;

    public ForumPost(String postBody, String postAuthor) {
        this.postBody = postBody;
        this.author = postAuthor;
    }

    public String getPostBody() {
        return postBody;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ForumPost forumPost = (ForumPost) o;

        if (!postBody.equals(forumPost.postBody)) {
            return false;
        }
        return author.equals(forumPost.author);
    }

    @Override
    public int hashCode() {
        int result = postBody.hashCode();
        result = 31 * result + author.hashCode();
        return result;
    }
}
