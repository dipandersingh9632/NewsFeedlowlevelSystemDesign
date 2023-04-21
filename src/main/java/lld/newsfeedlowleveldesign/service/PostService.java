package main.java.lld.newsfeedlowleveldesign.service;

import main.java.lld.newsfeedlowleveldesign.models.Post;

import java.util.Map;

public interface PostService {
    public String createPost(String text, Map<Integer, Post> postMap);
    public String upVoteOnPost(Integer id, Map<Integer,Post> postMap);
    public String downVoteOnPost(Integer id, Map<Integer,Post> postMap);
}
