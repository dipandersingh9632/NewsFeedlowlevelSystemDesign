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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, User> userMap = new HashMap<>();
        Map<Integer, Post> postMap = new HashMap<>();
        Map<Integer, Comment> commentMap = new HashMap<>();
        Map<Integer, SubComment> subCommentMap = new HashMap<>();
        List<Post> allPosts = new ArrayList<>();

        UserService userService = new UserServiceImpl();
        UserController userController = new UserController(userService);
        PostService newsFeedService = new PostServiceImpl();
        PostController postController = new PostController(newsFeedService);
        CommentService commentService = new CommentServiceImpl();
        CommentController commentController = new CommentController(commentService);
        SubCommentService subCommentService = new SubCommentServiceImpl();
        SubCommentController subCommentController = new SubCommentController(subCommentService);



        // multiple User signs up
        RequestUserDto requestUserDto1 = new RequestUserDto();
        requestUserDto1.setName("Depandre singh");
        requestUserDto1.setEmail("d@gmail.com");
        requestUserDto1.setPassword("123");
        System.out.println(userController.signup(requestUserDto1, userMap));

        RequestUserDto requestUserDto2 = new RequestUserDto();
        requestUserDto2.setName("Himanshu pandey");
        requestUserDto2.setEmail("h@gmail.com");
        requestUserDto2.setPassword("123");
        System.out.println(userController.signup(requestUserDto2, userMap));

        RequestUserDto requestUserDto3 = new RequestUserDto();
        requestUserDto3.setName("Ajay singh");
        requestUserDto3.setEmail("a@gmail.com");
        requestUserDto3.setPassword("123");
        System.out.println(userController.signup(requestUserDto3, userMap));



        // User logs in
        System.out.println(userController.login("d@gmail.com", "123", userMap));

        //User follow another user
        System.out.println(userController.follow("h@gmail.com",userMap));
        System.out.println(userController.follow("a@gmail.com", userMap));

        // another user logs in
        System.out.println(userController.login("h@gmail.com", "123", userMap));

        // User creates a post
        System.out.println(postController.post("Hello first post", postMap, allPosts));

        // User upvotes the post
        System.out.println(postController.upvote(1, postMap));

        // User upvotes the post again but it cannot be Upvote as user has already upVoted
        System.out.println(postController.upvote(1, postMap));

        // User downvotes the post
        System.out.println(postController.downvote(1, postMap));

        //User again Creates a post
        System.out.println(postController.post("Hello second post", postMap, allPosts));

        // another user logs in
        System.out.println(userController.login("a@gmail.com", "123", userMap));

        //User Creates a post
        System.out.println(postController.post("Hello my first post", postMap, allPosts));

        // another user logs in
        System.out.println(userController.login("d@gmail.com", "123", userMap));

        // User comments on the post
        System.out.println(commentController.reply(1,"great news", postMap, commentMap));

        // User upvotes the comment
        System.out.println(commentController.upvote(1,commentMap));

        // User downVote the comment
        System.out.println(commentController.downvote(1, commentMap));

        // another user logs in
        System.out.println(userController.login("h@gmail.com", "123", userMap));

        // User replies to the comment
        System.out.println(subCommentController.reply(1,"welcome", commentMap, subCommentMap));

        // User upvotes the sub-comment
        System.out.println(subCommentController.upvote(1,subCommentMap));

        // User downvotes the sub-comment
        System.out.println(subCommentController.downvote(1,subCommentMap));

        // another user logs in
        System.out.println(userController.login("d@gmail.com", "123", userMap));

        // User views their news feed, sorted by number of comments
        System.out.println(userController.shownewsfeed("SortByNumComments", allPosts));
    }


}