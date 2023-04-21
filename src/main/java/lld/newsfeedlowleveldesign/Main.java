package main.java.lld.newsfeedlowleveldesign;

import main.java.lld.newsfeedlowleveldesign.controller.PostController;
import main.java.lld.newsfeedlowleveldesign.controller.UserController;
import main.java.lld.newsfeedlowleveldesign.dto.RequestUserDto;
import main.java.lld.newsfeedlowleveldesign.models.Comment;
import main.java.lld.newsfeedlowleveldesign.models.Post;
import main.java.lld.newsfeedlowleveldesign.models.SubComment;
import main.java.lld.newsfeedlowleveldesign.models.User;
import main.java.lld.newsfeedlowleveldesign.service.PostService;
import main.java.lld.newsfeedlowleveldesign.service.PostServiceImpl;
import main.java.lld.newsfeedlowleveldesign.service.UserService;
import main.java.lld.newsfeedlowleveldesign.service.UserServiceImpl;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, User> users = new HashMap<>();
        Map<Integer, Post> postMap = new HashMap<>();
        Map<Integer, Comment> commentMap = new HashMap<>();
        Map<Integer, SubComment> subCommentMap = new HashMap<>();

        UserService userService = new UserServiceImpl();
        UserController userController = new UserController(userService);
        PostService newsFeedService = new PostServiceImpl();
        PostController postController = new PostController(newsFeedService);



        RequestUserDto requestUserDto = new RequestUserDto();
        requestUserDto.setName("Depandre singh");
        requestUserDto.setEmail("d@gmail.com");
        requestUserDto.setPassword("123");
        System.out.println(userController.signup(requestUserDto, users));

        System.out.println(userController.login("d@gmail.com", "123", users));

        System.out.println(postController.post("Hello first post", postMap));
        System.out.println(postController.upvote(1, postMap));
        System.out.println(postController.downvote(1, postMap));
        System.out.println(postMap.get(1));

    }
}
