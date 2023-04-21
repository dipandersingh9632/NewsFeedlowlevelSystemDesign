package main.java.lld.newsfeedlowleveldesign.service;

import main.java.lld.newsfeedlowleveldesign.models.Comment;
import main.java.lld.newsfeedlowleveldesign.models.Post;
import main.java.lld.newsfeedlowleveldesign.models.User;
import main.java.lld.newsfeedlowleveldesign.session.SessionManager;

import java.util.Map;

public class CommentServiceImpl implements CommentService{

    @Override
    public String replyToPost(Integer postId, String text, Map<Integer, Post> postMap, Map<Integer, Comment> commentMap) {
        User loggedUser = getLoggedUser();
        if(loggedUser == null) return "PLEASE LOGIN FIRST";
        if(!postMap.containsKey(postId)) return "NO POST FOR THIS ID " + postId;
        Comment comment = new Comment(text, loggedUser, postId);
        Post currPost = postMap.get(postId);
        currPost.getCommentList().add(comment);
        commentMap.put(commentMap.size()+1, comment);
        return "COMMENT ADDED SUCCESSFULLY";
    }

    @Override
    public String upvoteComment(Integer commentId, Map<Integer, Comment> commentMap) {
        User loggedUser = getLoggedUser();
        if(loggedUser == null) return "PLEASE LOGIN FIRST";
        if(!commentMap.containsKey(commentId)) return "NO COMMENT-ID for this ID " + commentId;
        Comment comment = commentMap.get(commentId);
        if(comment.getUpVoteCommentSet().contains(loggedUser)) return "ALREADY UP-VOTED";
        comment.getUpVoteCommentSet().add(loggedUser);
        comment.setUpVotes(comment.getUpVotes() + 1);
        return "UP-VOTED SUCCESSFULLY";
    }

    @Override
    public String downvoteComment(Integer commentId, Map<Integer, Comment> commentMap) {
        User loggedUser = getLoggedUser();
        if(loggedUser == null) return "PLEASE LOGIN FIRST";
        if(!commentMap.containsKey(commentId)) return "NO COMMENT-ID for this ID " + commentId;
        Comment comment = commentMap.get(commentId);
        if(comment.getDownVoteCommentSet().contains(loggedUser)) return "ALREADY DOWN-VOTED";
        comment.getDownVoteCommentSet().add(loggedUser);
        comment.setDownVotes(comment.getDownVotes() + 1);
        return "DOWN-VOTED SUCCESSFULLY";
    }

    private User getLoggedUser() {
        if (SessionManager.getLoggedInUser() == null) return null;
        return SessionManager.getLoggedInUser();
    }

}
