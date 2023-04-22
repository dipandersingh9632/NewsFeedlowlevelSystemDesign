package main.java.lld.newsfeedlowleveldesign.service.sortingStrategy;

import main.java.lld.newsfeedlowleveldesign.models.Post;
import main.java.lld.newsfeedlowleveldesign.models.User;
import main.java.lld.newsfeedlowleveldesign.session.SessionManager;

import java.util.ArrayList;
import java.util.List;

public class SortByFollowedUsers implements NewsFeedSortingStrategy {
    @Override
    public List<Post> sortNewsFeed(List<Post> allPosts) {
        User loggedUser = getLoggedUser();
        if(loggedUser == null){
            System.out.println("PLEASE LOGIN FIRST");
            return null;
        }
        List<User> followingUsers = loggedUser.getFollowing();
        List<Post> posts = new ArrayList<>();
        for(User followingUser : followingUsers){
            posts.addAll(followingUser.getPosts());
        }
        return posts;
    }

    private User getLoggedUser() {
        if (SessionManager.getLoggedInUser() == null) return null;
        return SessionManager.getLoggedInUser();
    }
}
