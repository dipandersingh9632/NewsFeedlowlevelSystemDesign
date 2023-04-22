package main.java.lld.newsfeedlowleveldesign.service.sortingStrategy;

import main.java.lld.newsfeedlowleveldesign.models.Post;

import java.util.List;

public interface NewsFeedSortingStrategy {
    List<Post> sortNewsFeed(List<Post> allPosts);
}
