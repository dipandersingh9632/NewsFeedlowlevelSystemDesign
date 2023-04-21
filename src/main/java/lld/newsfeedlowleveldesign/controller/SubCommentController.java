package main.java.lld.newsfeedlowleveldesign.controller;

import main.java.lld.newsfeedlowleveldesign.models.Comment;
import main.java.lld.newsfeedlowleveldesign.models.SubComment;
import main.java.lld.newsfeedlowleveldesign.service.SubCommentService;

import java.util.Map;

public class SubCommentController {
    private SubCommentService subCommentService;

    public SubCommentController(SubCommentService subCommentService){
        this.subCommentService = subCommentService;
    }

    public String reply(Integer commentId, String text, Map<Integer, Comment> commentMap, Map<Integer, SubComment> subCommentMap){
        return subCommentService.replyToComment(commentId, text, commentMap, subCommentMap);
    }

    public String upvote(Integer subCommentId, Map<Integer, SubComment> subCommentMap){
        return subCommentService.upvoteSubComment(subCommentId, subCommentMap);
    }

    public String downvote(Integer subCommentId, Map<Integer, SubComment> subCommentMap){
        return subCommentService.downvoteSubComment(subCommentId, subCommentMap);
    }

}
