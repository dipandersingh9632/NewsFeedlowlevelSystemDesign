package main.java.lld.newsfeedlowleveldesign.service;

import main.java.lld.newsfeedlowleveldesign.models.Comment;
import main.java.lld.newsfeedlowleveldesign.models.Post;
import main.java.lld.newsfeedlowleveldesign.models.SubComment;

import java.util.Map;

public interface SubCommentService {
    public String replyToComment(Integer commentId, String text, Map<Integer, Comment> commentMap, Map<Integer, SubComment> subCommentMap);
    public String upvoteSubComment(Integer subCommentId,  Map<Integer,SubComment> subCommentMap);
    public String downvoteSubComment(Integer subCommentId, Map<Integer,SubComment> subCommentMap);
}
