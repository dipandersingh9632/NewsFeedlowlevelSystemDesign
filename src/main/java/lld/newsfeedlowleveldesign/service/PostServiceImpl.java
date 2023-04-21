package main.java.lld.newsfeedlowleveldesign.service;

import main.java.lld.newsfeedlowleveldesign.models.User;
import main.java.lld.newsfeedlowleveldesign.models.Post;
import main.java.lld.newsfeedlowleveldesign.session.SessionManager;


import java.util.Map;

public class PostServiceImpl implements PostService {
    @Override
    public String createPost(String text, Map<Integer, Post> postMap) {
        User loggedInUser = getLoggedUser();
        if(loggedInUser == null) return "PLEASE LOGIN FIRST";
        Post newsFeed = new Post(text, loggedInUser);
        postMap.put(postMap.size()+1, newsFeed);
        return "Post added successfully";
    }
    @Override
    public String upVoteOnPost(Integer id, Map<Integer, Post> postMap) {
        User loggedInUser = getLoggedUser();
        if(loggedInUser == null)  return "PLEASE LOGIN FIRST";
        if(!postMap.containsKey(id)) return "POST NOT FOUND FOR THIS ID " + id;
        Post currPost = postMap.get(id);
        if(currPost.getUpVoteSet().contains(loggedInUser)) return "ALREADY UP-VOTE";
        currPost.setUpVotes(currPost.getUpVotes() + 1);
        currPost.getUpVoteSet().add(loggedInUser);
        return "UpVoted SUCCESSFULLY";
    }
    @Override
    public String downVoteOnPost(Integer id, Map<Integer, Post> postMap) {
        User loggedInUser = getLoggedUser();
        if(loggedInUser == null)  return "PLEASE LOGIN FIRST";
        if(!postMap.containsKey(id)) return "POST NOT FOUND FOR THIS ID " + id;
        Post currPost = postMap.get(id);
        if(currPost.getUpVoteSet().contains(loggedInUser)) return "ALREADY DOWN-VOTE";
        currPost.setDownVotes(currPost.getDownVotes() + 1);
        currPost.getDownVoteSet().add(loggedInUser);
        return "DownVoted SUCCESSFULLY";
    }

    private User getLoggedUser() {
        if (SessionManager.getLoggedInUser() == null) return null;
        return SessionManager.getLoggedInUser();
    }
}
