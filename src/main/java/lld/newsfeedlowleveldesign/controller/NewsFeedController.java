package main.java.lld.newsfeedlowleveldesign.controller;

import main.java.lld.newsfeedlowleveldesign.models.NewsFeed;
import main.java.lld.newsfeedlowleveldesign.service.NewsFeedService;

import java.util.Map;

public class NewsFeedController {

    private NewsFeedService newsFeedService;

    public NewsFeedController(NewsFeedService newsFeedService){
        this.newsFeedService = newsFeedService;
    }

    public String post(String text, Map<Integer,NewsFeed> newsFeedMap){
        return newsFeedService.createPost(text, newsFeedMap);
    }

    public String upvote(Integer id, Map<Integer,NewsFeed> newsFeedMap){
        return newsFeedService.upVoteOnPost(id, newsFeedMap);
    }

    public String downvote(Integer id, Map<Integer,NewsFeed> newsFeedMap){
        return newsFeedService.downVoteOnPost(id, newsFeedMap);
    }

}
