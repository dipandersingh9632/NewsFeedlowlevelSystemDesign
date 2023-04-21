package main.java.lld.newsfeedlowleveldesign.service;

import main.java.lld.newsfeedlowleveldesign.models.Comment;
import main.java.lld.newsfeedlowleveldesign.models.SubComment;
import main.java.lld.newsfeedlowleveldesign.models.User;
import main.java.lld.newsfeedlowleveldesign.session.SessionManager;

import java.util.Map;

public class SubCommentServiceImpl implements SubCommentService{
    @Override
    public String replyToComment(Integer commentId, String text, Map<Integer, Comment> commentMap, Map<Integer, SubComment> subCommentMap) {
        User loggedUser = getLoggedUser();
        if(loggedUser == null) return "PLEASE LOGIN FIRST";
        if(!commentMap.containsKey(commentId)) return "NO COMMENT FOR THIS ID " + commentId;
        SubComment subComment = new SubComment(text, loggedUser, commentId);
        Comment currComment = commentMap.get(commentId);
        currComment.getSubCommentList().add(subComment);
        subCommentMap.put(subCommentMap.size()+1, subComment);
        return "SUB-COMMENT ADDED SUCCESSFULLY";
    }

    @Override
    public String upvoteSubComment(Integer subCommentId, Map<Integer, SubComment> subCommentMap) {
        User loggedUser = getLoggedUser();
        if(loggedUser == null) return "PLEASE LOGIN FIRST";
        if(!subCommentMap.containsKey(subCommentId)) return "NO SUB-COMMENT-ID for this ID " + subCommentId;
        SubComment subComment = subCommentMap.get(subCommentId);
        if(subComment.getUpVoteSubCommentSet().contains(loggedUser)) return "ALREADY UP-VOTED";
        subComment.getUpVoteSubCommentSet().add(loggedUser);
        subComment.setUpVotes(subComment.getUpVotes() + 1);
        return "UP-VOTED SUCCESSFULLY";
    }

    @Override
    public String downvoteSubComment(Integer subCommentId, Map<Integer, SubComment> subCommentMap) {
        User loggedUser = getLoggedUser();
        if(loggedUser == null) return "PLEASE LOGIN FIRST";
        if(!subCommentMap.containsKey(subCommentId)) return "NO SUB-COMMENT-ID for this ID " + subCommentId;
        SubComment subComment = subCommentMap.get(subCommentId);
        if(subComment.getDownVoteSubCommentSet().contains(loggedUser)) return "ALREADY UP-VOTED";
        subComment.getDownVoteSubCommentSet().add(loggedUser);
        subComment.setDownVotes(subComment.getDownVotes() + 1);
        return "DOWN-VOTED SUCCESSFULLY";
    }

    private User getLoggedUser() {
        if (SessionManager.getLoggedInUser() == null) return null;
        return SessionManager.getLoggedInUser();
    }
}
