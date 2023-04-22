package main.java.lld.newsfeedlowleveldesign.service;

import main.java.lld.newsfeedlowleveldesign.models.Post;

import java.util.List;
import java.util.Map;

public interface PostService {
    public String createPost(String text, Map<Integer, Post> postMap, List<Post> allPosts);
    public String upVoteOnPost(Integer id, Map<Integer,Post> postMap);
    public String downVoteOnPost(Integer id, Map<Integer,Post> postMap);
}
