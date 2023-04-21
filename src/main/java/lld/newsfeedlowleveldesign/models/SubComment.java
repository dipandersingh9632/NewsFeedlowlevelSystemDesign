package main.java.lld.newsfeedlowleveldesign.models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class SubComment {
    private String commentText;
    private User user;
    private int upVotes;
    private Set<User> upVoteSubCommentSet;
    private Set<User> downVoteSubCommentSet;
    private int downVotes;
    private int commentId;
    private Date timestamp;

    public SubComment(String commentText, User user, int commentId) {
        this.commentText = commentText;
        this.user = user;
        this.commentId = commentId;
        this.downVotes = 0;
        this.upVotes = 0;
        this.downVoteSubCommentSet = new HashSet<>();
        this.upVoteSubCommentSet = new HashSet<>();
        this.timestamp = new Date();
    }

    @Override
    public String toString() {
        return "SubComment{" +
                "commentText='" + commentText + '\'' +
                ", user=" + user +
                ", upVotes=" + upVotes +
                ", upVoteSubCommentSet=" + upVoteSubCommentSet +
                ", downVoteSubCommentSet=" + downVoteSubCommentSet +
                ", downVotes=" + downVotes +
                ", commentId=" + commentId +
                ", timestamp=" + timestamp +
                '}';
    }

    public Set<User> getUpVoteSubCommentSet() {
        return upVoteSubCommentSet;
    }

    public void setUpVoteSubCommentSet(Set<User> upVoteSubCommentSet) {
        this.upVoteSubCommentSet = upVoteSubCommentSet;
    }

    public Set<User> getDownVoteSubCommentSet() {
        return downVoteSubCommentSet;
    }

    public void setDownVoteSubCommentSet(Set<User> downVoteSubCommentSet) {
        this.downVoteSubCommentSet = downVoteSubCommentSet;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
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

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
