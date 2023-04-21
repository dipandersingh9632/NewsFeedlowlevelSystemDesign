package main.java.lld.newsfeedlowleveldesign.controller;

import main.java.lld.newsfeedlowleveldesign.models.Comment;
import main.java.lld.newsfeedlowleveldesign.models.Post;
import main.java.lld.newsfeedlowleveldesign.service.CommentService;

import java.util.Map;

public class CommentController {
    private CommentService commentService;

    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }

    public String reply(Integer postId, String text, Map<Integer, Post> postMap, Map<Integer, Comment> commentMap){
        return commentService.replyToPost(postId, text, postMap, commentMap);
    }

    public String upvote(Integer commentId, Map<Integer, Comment> commentMap){
        return commentService.upvoteComment(commentId, commentMap);
    }

    public String downvote(Integer commentId, Map<Integer, Comment> commentMap){
        return commentService.downvoteComment(commentId, commentMap);
    }
}
