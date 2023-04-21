package main.java.lld.newsfeedlowleveldesign.models;

import java.util.*;

public class Comment {
    private String commentText;
    private User user;
    List<SubComment> subCommentList;
    private int upVotes;
    private int downVotes;
    private Set<User> upVoteCommentSet;
    private Set<User> downVoteCommentSet;
    private int postId;
    private Date timestamp;

    public Comment(String commentText, User user, int postId){
        this.commentText = commentText;
        this.user = user;
        this.postId = postId;
        this.upVotes = 0;
        this.downVotes = 0;
        this.upVoteCommentSet = new HashSet<>();
        this.downVoteCommentSet = new HashSet<>();
        this.subCommentList = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentText='" + commentText + '\'' +
                ", user=" + user +
                ", upVotes=" + upVotes +
                ", downVotes=" + downVotes +
                ", upVoteCommentSet=" + upVoteCommentSet +
                ", downVoteCommentSet=" + downVoteCommentSet +
                ", postId=" + postId +
                ", timestamp=" + timestamp +
                '}';
    }

    public Set<User> getUpVoteCommentSet() {
        return upVoteCommentSet;
    }

    public void setUpVoteCommentSet(Set<User> upVoteCommentSet) {
        this.upVoteCommentSet = upVoteCommentSet;
    }

    public Set<User> getDownVoteCommentSet() {
        return downVoteCommentSet;
    }

    public void setDownVoteCommentSet(Set<User> downVoteCommentSet) {
        this.downVoteCommentSet = downVoteCommentSet;
    }

    public List<SubComment> getSubCommentList() {
        return subCommentList;
    }

    public void setSubCommentList(List<SubComment> subCommentList) {
        this.subCommentList = subCommentList;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
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


    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
