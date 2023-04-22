package main.java.lld.newsfeedlowleveldesign.service.sortingStrategy;

import main.java.lld.newsfeedlowleveldesign.models.Post;

import java.util.Comparator;
import java.util.List;

public class SortByScore implements NewsFeedSortingStrategy{
    @Override
    public List<Post> sortNewsFeed(List<Post> allPosts) {
        allPosts.sort(new Comparator<Post>() {
            @Override
            public int compare(Post p1, Post p2) {
                return (p2.getUpVotes()) - p2.getDownVotes() - (p1.getUpVotes() - p2.getDownVotes());
            }
        });
        return allPosts;
    }
}
