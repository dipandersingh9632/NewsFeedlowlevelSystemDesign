package main.java.lld.newsfeedlowleveldesign.controller;

import main.java.lld.newsfeedlowleveldesign.models.Post;
import main.java.lld.newsfeedlowleveldesign.service.PostService;

import java.util.Map;

public class PostController {

    private PostService postService;

    public PostController(PostService postService){
        this.postService = postService;
    }

    public String post(String text, Map<Integer,Post> postMap){
        return postService.createPost(text, postMap);
    }

    public String upvote(Integer id, Map<Integer,Post> postMap){
        return postService.upVoteOnPost(id, postMap);
    }

    public String downvote(Integer id, Map<Integer,Post> postMap){
        return postService.downVoteOnPost(id, postMap);
    }

}
