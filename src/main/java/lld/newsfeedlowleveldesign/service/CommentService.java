package main.java.lld.newsfeedlowleveldesign.service;

import main.java.lld.newsfeedlowleveldesign.models.Comment;
import main.java.lld.newsfeedlowleveldesign.models.Post;

import java.util.Map;

public interface CommentService {
    public String replyToPost(Integer postId, String text, Map<Integer, Post> postMap, Map<Integer, Comment> commentMap);
    public String upvoteComment(Integer commentId,  Map<Integer,Comment> commentMap);
    public String downvoteComment(Integer commentId, Map<Integer,Comment> commentMap);
}
