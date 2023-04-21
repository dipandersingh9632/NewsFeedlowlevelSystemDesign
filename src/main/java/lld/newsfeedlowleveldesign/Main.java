package main.java.lld.newsfeedlowleveldesign;

import main.java.lld.newsfeedlowleveldesign.controller.CommentController;
import main.java.lld.newsfeedlowleveldesign.controller.PostController;
import main.java.lld.newsfeedlowleveldesign.controller.SubCommentController;
import main.java.lld.newsfeedlowleveldesign.controller.UserController;
import main.java.lld.newsfeedlowleveldesign.dto.RequestUserDto;
import main.java.lld.newsfeedlowleveldesign.models.Comment;
import main.java.lld.newsfeedlowleveldesign.models.Post;
import main.java.lld.newsfeedlowleveldesign.models.SubComment;
import main.java.lld.newsfeedlowleveldesign.models.User;
import main.java.lld.newsfeedlowleveldesign.service.*;
import main.java.lld.newsfeedlowleveldesign.session.SessionManager;

import java.util.*;

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
        CommentService commentService = new CommentServiceImpl();
        CommentController commentController = new CommentController(commentService);
        SubCommentService subCommentService = new SubCommentServiceImpl();
        SubCommentController subCommentController = new SubCommentController(subCommentService);



        RequestUserDto requestUserDto = new RequestUserDto();
        requestUserDto.setName("Depandre singh");
        requestUserDto.setEmail("d@gmail.com");
        requestUserDto.setPassword("123");
        System.out.println(userController.signup(requestUserDto, users));

        System.out.println(userController.login("d@gmail.com", "123", users));

        System.out.println(postController.post("Hello first post", postMap));
        System.out.println(postController.upvote(1, postMap));
        System.out.println(postController.upvote(1, postMap));
        System.out.println(postController.downvote(1, postMap));
        System.out.println(postMap.get(1));

        System.out.println(commentController.reply(1,"great news", postMap, commentMap));
        System.out.println(commentController.upvote(1,commentMap));
        System.out.println(commentController.downvote(1, commentMap));
        System.out.println(commentMap.get(1));

        System.out.println(subCommentController.reply(1,"welcome", commentMap, subCommentMap));
        System.out.println(subCommentController.upvote(1,subCommentMap));
        System.out.println(subCommentController.downvote(1,subCommentMap));
        System.out.println(subCommentMap.get(1));
    }
}