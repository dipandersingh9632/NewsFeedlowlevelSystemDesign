package main.java.lld.newsfeedlowleveldesign.service;

import main.java.lld.newsfeedlowleveldesign.models.User;

import java.util.Map;

public interface UserService {
    public String createUser(User user, Map<String, User> userMap);
    public String loginUser(String email, String password, Map<String,User> userMap);
}
