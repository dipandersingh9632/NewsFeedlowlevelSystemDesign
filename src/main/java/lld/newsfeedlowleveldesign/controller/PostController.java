package main.java.lld.newsfeedlowleveldesign.controller;

import main.java.lld.newsfeedlowleveldesign.models.Post;
import main.java.lld.newsfeedlowleveldesign.service.PostService;

import java.util.List;
import java.util.Map;

public class PostController {

    private PostService postService;

    public PostController(PostService postService){
        this.postService = postService;
    }

    public String post(String text, Map<Integer,Post> postMap, List<Post> allPosts){
        return postService.createPost(text, postMap, allPosts);
    }

    public String upvote(Integer id, Map<Integer,Post> postMap){
        return postService.upVoteOnPost(id, postMap);
    }

    public String downvote(Integer id, Map<Integer,Post> postMap){
        return postService.downVoteOnPost(id, postMap);
    }

}
