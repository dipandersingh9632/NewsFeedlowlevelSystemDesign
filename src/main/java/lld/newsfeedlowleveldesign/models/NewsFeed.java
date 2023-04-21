package main.java.lld.newsfeedlowleveldesign.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NewsFeed {
    private String newsArticle;
    private User user;
    private int upVotes;
    private int downVotes;
    private List<Comment> commentList;
    private Date timestamp;

    public NewsFeed(String newsArticle, User user){
        this.newsArticle = newsArticle;
        this.user = user;
        this.upVotes = 0;
        this.downVotes = 0;
        this.commentList = new ArrayList<>();
        this.timestamp = new Date();
    }

    @Override
    public String toString() {
        return "NewsFeed{" +
                "newsArticle='" + newsArticle + '\'' +
                ", user=" + user +
                ", upVotes=" + upVotes +
                ", downVotes=" + downVotes +
                ", commentList=" + commentList +
                ", timestamp=" + timestamp +
                '}';
    }

    public String getNewsArticle() {
        return newsArticle;
    }

    public void setNewsArticle(String newsArticle) {
        this.newsArticle = newsArticle;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getUpVotes() {
        return upVotes;
    }

    public void setUpVotes(int upVotes) {
        this.upVotes = upVotes;
    }

    public int getDownVotes() {
        return downVotes;
    }

    public void setDownVotes(int downVotes) {
        this.downVotes = downVotes;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
