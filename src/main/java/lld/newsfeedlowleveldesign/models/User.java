package main.java.lld.newsfeedlowleveldesign.models;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String email;
    private String password;
    private List<User> followingUsers;
    private List<Post> posts;

    private User(Builder builder){
        this.name = builder.name;
        this.email = builder.email;
        this.password = builder.password;
        if(builder.followingUsers == null) this.followingUsers = new ArrayList<>();
        else this.followingUsers = builder.followingUsers;
        if(builder.posts == null) this.posts = new ArrayList<>();
        else this.posts = builder.posts;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
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

    public List<User> getFollowing() {
        return followingUsers;
    }

    public void setFollowing(List<User> following) {
        this.followingUsers = followingUsers;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", following=" + followingUsers +
                '}';
    }

    // Builder class
    public static class Builder{
        private String name;
        private String email;
        private String password;
        private List<User> followingUsers;
        private List<Post> posts;

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
        public Builder setFollowing(List<User> followingUsers){
            this.followingUsers = followingUsers;
            return this;
        }

        public Builder setPosts(List<Post> posts){
            this.posts = posts;
            return this;
        }
        public User build(){
            return new User(this);
        }
    }
}
