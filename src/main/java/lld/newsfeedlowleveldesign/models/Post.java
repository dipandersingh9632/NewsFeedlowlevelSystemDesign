package main.java.lld.newsfeedlowleveldesign.models;

import java.util.*;

public class Post {
    private String text;
    private User user;
    private int upVotes;
    private int downVotes;
    private Set<User> upVoteSet;
    private Set<User> downVoteSet;
    private List<Comment> commentList;
    private Date timestamp;

    public Post(String newsArticle, User user){
        this.text = newsArticle;
        this.user = user;
        this.upVotes = 0;
        this.downVotes = 0;
        this.commentList = new ArrayList<>();
        this.timestamp = new Date();
        upVoteSet = new HashSet<>();
        downVoteSet = new HashSet<>();
    }

    @Override
    public String toString() {
        return "Post{" +
                "text='" + text + '\'' +
                ", user=" + user +
                ", upVotes=" + upVotes +
                ", downVotes=" + downVotes +
                ", upVoteSet=" + upVoteSet +
                ", downVoteSet=" + downVoteSet +
                ", commentList=" + commentList +
                ", timestamp=" + timestamp +
                '}';
    }

    public Set<User> getUpVoteSet() {
        return upVoteSet;
    }

    public void setUpVoteSet(Set<User> upVoteSet) {
        this.upVoteSet = upVoteSet;
    }

    public Set<User> getDownVoteSet() {
        return downVoteSet;
    }

    public void setDownVoteSet(Set<User> downVoteSet) {
        this.downVoteSet = downVoteSet;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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
