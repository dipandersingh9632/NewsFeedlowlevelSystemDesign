package main.java.lld.newsfeedlowleveldesign;

import main.java.lld.newsfeedlowleveldesign.controller.NewsFeedController;
import main.java.lld.newsfeedlowleveldesign.controller.UserController;
import main.java.lld.newsfeedlowleveldesign.dto.RequestUserDto;
import main.java.lld.newsfeedlowleveldesign.models.NewsFeed;
import main.java.lld.newsfeedlowleveldesign.models.User;
import main.java.lld.newsfeedlowleveldesign.service.NewsFeedService;
import main.java.lld.newsfeedlowleveldesign.service.NewsFeedServiceImpl;
import main.java.lld.newsfeedlowleveldesign.service.UserService;
import main.java.lld.newsfeedlowleveldesign.service.UserServiceImpl;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, User> users = new HashMap<>();
        Map<Integer, NewsFeed> newsFeedMap = new HashMap<>();
        UserService userService = new UserServiceImpl();
        UserController userController = new UserController(userService);
        NewsFeedService newsFeedService = new NewsFeedServiceImpl();
        NewsFeedController newsFeedController = new NewsFeedController(newsFeedService);


        RequestUserDto requestUserDto = new RequestUserDto();
        requestUserDto.setName("Depandre singh");
        requestUserDto.setEmail("d@gmail.com");
        requestUserDto.setPassword("123");
        System.out.println(userController.signup(requestUserDto, users));

        System.out.println(userController.login("d@gmail.com", "123", users));

        System.out.println(newsFeedController.post("Hello first post", newsFeedMap));
        System.out.println(newsFeedController.upvote(1, newsFeedMap));
        System.out.println(newsFeedController.downvote(1, newsFeedMap));
        System.out.println(newsFeedMap.get(1));

    }
}
