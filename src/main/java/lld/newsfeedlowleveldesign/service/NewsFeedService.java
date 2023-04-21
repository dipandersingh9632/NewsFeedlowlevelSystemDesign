package main.java.lld.newsfeedlowleveldesign.service;

import main.java.lld.newsfeedlowleveldesign.models.NewsFeed;

import java.util.Map;

public interface NewsFeedService {
    public String createPost(String text, Map<Integer, NewsFeed> newsFeedMap);
    public String upVoteOnPost(Integer id, Map<Integer,NewsFeed> newsFeedMap);
    public String downVoteOnPost(Integer id, Map<Integer,NewsFeed> newsFeedMap);
}
