package main.java.lld.newsfeedlowleveldesign.controller;

import main.java.lld.newsfeedlowleveldesign.dto.RequestUserDto;
import main.java.lld.newsfeedlowleveldesign.models.User;
import main.java.lld.newsfeedlowleveldesign.service.UserService;

import java.util.Map;

public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    public String signup(RequestUserDto requestUserDto, Map<String,User> userMap){
        User user = mapDtoToUser(requestUserDto);
        return userService.createUser(user, userMap);
    }

    public String login(String email, String password, Map<String,User> userMap){
        return userService.loginUser(email, password, userMap);
    }

    public User mapDtoToUser(RequestUserDto requestUserDto){
        return User.Builder.getBuilder().setName(requestUserDto.getName()).setEmail(requestUserDto.getEmail())
                .setPassword(requestUserDto.getPassword()).setFollowers(requestUserDto.getFollowers())
                .setFollowing(requestUserDto.getFollowing()).setNewsFeed(requestUserDto.getNewsFeedList()).build();
    }

}
