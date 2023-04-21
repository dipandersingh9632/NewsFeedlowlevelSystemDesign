package main.java.lld.newsfeedlowleveldesign.models;

import java.util.*;

public class Post {
    private String text;
    private User user;
    private int upVotes;
    private int downVotes;
    private Set<User> upVotePostSet;
    private Set<User> downVotePostSet;
    private List<Comment> commentList;
    private Date timestamp;

    public Post(String newsArticle, User user){
        this.text = newsArticle;
        this.user = user;
        this.upVotes = 0;
        this.downVotes = 0;
        this.commentList = new ArrayList<>();
        this.timestamp = new Date();
        upVotePostSet = new HashSet<>();
        downVotePostSet = new HashSet<>();
    }

    @Override
    public String toString() {
        return "Post{" +
                "text='" + text + '\'' +
                ", user=" + user +
                ", upVotes=" + upVotes +
                ", downVotes=" + downVotes +
                ", upVoteSet=" + upVotePostSet +
                ", downVoteSet=" + downVotePostSet +
                ", commentList=" + commentList +
                ", timestamp=" + timestamp +
                '}';
    }

    public Set<User> getUpVotePostSet() {
        return upVotePostSet;
    }

    public void setUpVotePostSet(Set<User> upVotePostSet) {
        this.upVotePostSet = upVotePostSet;
    }

    public Set<User> getDownVotePostSet() {
        return downVotePostSet;
    }

    public void setDownVotePostSet(Set<User> downVotePostSet) {
        this.downVotePostSet = downVotePostSet;
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
