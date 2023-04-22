package main.java.lld.newsfeedlowleveldesign.dto;

import main.java.lld.newsfeedlowleveldesign.models.Comment;
import main.java.lld.newsfeedlowleveldesign.models.SubComment;

import java.util.ArrayList;
import java.util.List;

public class ResponsePostDto {
    private String textPost;
    private String userName;
    private int upVotes;
    private int downVotes;
    private String time;
    private List<Comment> comments;

    public ResponsePostDto() {
        this.comments = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Post: " + this.textPost +
                " postedBy: " + this.userName +
                " time: " + this.time +
                " upVoteCount: " + this.upVotes +
                " downVoteCount: " + this.downVotes +
                "\n" + "\t" +
                " comments :" +
                 getCommentList() + "\n";
    }

    private String getCommentList() {
        StringBuilder commentText = new StringBuilder();
        for(Comment comment : this.comments){
            commentText.append(comment.getCommentText())
                    .append(" postedBy: ").append(comment.getUser().getName())
                    .append(" upVotes: ").append(comment.getUpVotes())
                    .append(" downVotes: ").append(comment.getDownVotes())
                    .append("\n").append("\t").append("\t").append("subComment ").append(getSubComment(comment.getSubCommentList()));
        }
        return commentText.toString();
    }

    private StringBuilder getSubComment(List<SubComment> subComments){
        StringBuilder subCommentText = new StringBuilder();
        for(SubComment subComment : subComments){
            subCommentText.append(subComment.getCommentText())
                .append(" postedBy: ").append(subComment.getUser().getName())
                .append(" SubCommentUpVotes: ").append(subComment.getUpVotes())
                .append(" subCommentDownVotes: ").append(subComment.getDownVotes());
        }
        return subCommentText;
    }

    public String getTextPost() {
        return textPost;
    }

    public void setTextPost(String textPost) {
        this.textPost = textPost;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
