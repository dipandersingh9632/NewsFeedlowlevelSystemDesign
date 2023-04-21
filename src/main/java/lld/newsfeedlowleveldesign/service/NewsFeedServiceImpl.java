package main.java.lld.newsfeedlowleveldesign.service;

import main.java.lld.newsfeedlowleveldesign.models.NewsFeed;
import main.java.lld.newsfeedlowleveldesign.models.User;
import main.java.lld.newsfeedlowleveldesign.session.SessionManager;

import java.util.Map;

public class NewsFeedServiceImpl implements NewsFeedService{
    @Override
    public String createPost(String text, Map<Integer, NewsFeed> newsFeedMap) {
        User loggedInUser = getLoggedUser();
        if(loggedInUser == null) return "PLEASE LOGIN FIRST";
        NewsFeed newsFeed = new NewsFeed(text, loggedInUser);
        newsFeedMap.put(newsFeedMap.size()+1, newsFeed);
        return "Post added successfully";
    }
    @Override
    public String upVoteOnPost(Integer id, Map<Integer, NewsFeed> newsFeedMap) {
        User loggedInUser = getLoggedUser();
        if(loggedInUser == null)  return "PLEASE LOGIN FIRST";
        if(!newsFeedMap.containsKey(id)) return "POST NOT FOUND FOR THIS ID " + id;
        NewsFeed currPost = newsFeedMap.get(id);
        if(currPost.getUser().equals(loggedInUser)) return "CANNOT UPVOTE AS YOU ARE CREATOR OF POST";
        currPost.setUpVotes(currPost.getUpVotes() + 1);
        return "UpVoted SUCCESSFULLY";
    }
    @Override
    public String downVoteOnPost(Integer id, Map<Integer, NewsFeed> newsFeedMap) {
        User loggedInUser = getLoggedUser();
        if(loggedInUser == null)  return "PLEASE LOGIN FIRST";
        if(!newsFeedMap.containsKey(id)) return "POST NOT FOUND FOR THIS ID " + id;
        NewsFeed currPost = newsFeedMap.get(id);
        if(currPost.getUser().equals(loggedInUser)) return "CANNOT DOWNVOTE AS YOU ARE CREATOR OF POST";
        currPost.setDownVotes(currPost.getDownVotes() + 1);
        return "downVoted SUCCESSFULLY";
    }

    private User getLoggedUser() {
        if (SessionManager.getLoggedInUser() == null) return null;
        return SessionManager.getLoggedInUser();
    }
}
