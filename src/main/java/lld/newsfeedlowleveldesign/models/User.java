package main.java.lld.newsfeedlowleveldesign.models;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String email;
    private String password;
    private List<User> followers;
    private List<User> following;
    private List<NewsFeed> newsFeedList;

    private User(Builder builder){
        this.name = builder.name;
        this.email = builder.email;
        this.password = builder.password;
        if(builder.followers == null) this.followers = new ArrayList<>();
        else this.followers = builder.followers;
        if(builder.following == null) this.following = new ArrayList<>();
        else this.following = builder.following;
        if(builder.newsFeedList == null) this.newsFeedList = new ArrayList<>();
        else this.newsFeedList = builder.newsFeedList;
    }

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

    public List<NewsFeed> getNewsFeedList() {
        return newsFeedList;
    }

    public void setNewsFeedList(List<NewsFeed> newsFeedList) {
        this.newsFeedList = newsFeedList;
    }


    // Builder class
    public static class Builder{
        private String name;
        private String email;
        private String password;
        private List<User> followers;
        private List<User> following;
        private List<NewsFeed> newsFeedList;

        public static Builder getBuilder(){ return new Builder(); }

        public Builder setName(String name){
            this.name = name;
            return this;
        }

        public Builder setEmail(String email){
            this.email = email;
            return this;
        }
        public Builder setPassword(String password){
            this.password = password;
            return this;
        }
        public Builder setFollowers(List<User> followers){
            this.followers = followers;
            return this;
        }
        public Builder setFollowing(List<User> following){
            this.following = following;
            return this;
        }
        public Builder setNewsFeed(List<NewsFeed> newsFeedList){
            this.newsFeedList = newsFeedList;
            return this;
        }
        public User build(){
            return new User(this);
        }
    }
}