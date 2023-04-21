package main.java.lld.newsfeedlowleveldesign.dto;

import main.java.lld.newsfeedlowleveldesign.models.Post;
import main.java.lld.newsfeedlowleveldesign.models.User;

import java.util.List;

public class RequestUserDto {
    private String name;
    private String email;
    private String password;
    private List<User> followers;
    private List<User> following;
    private List<Post> postList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<User> getFollowers() {
        return followers;
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }

    public List<User> getFollowing() {
        return following;
    }

    public void setFollowing(List<User> following) {
        this.following = following;
    }

    public List<Post> getNewsFeedList() {
        return postList;
    }

    public void setNewsFeedList(List<Post> postList) {
        this.postList = postList;
    }
}
