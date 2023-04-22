package main.java.lld.newsfeedlowleveldesign.controller;

import main.java.lld.newsfeedlowleveldesign.controller.factory.SortStrategyFactory;
import main.java.lld.newsfeedlowleveldesign.dto.RequestUserDto;
import main.java.lld.newsfeedlowleveldesign.dto.ResponsePostDto;
import main.java.lld.newsfeedlowleveldesign.models.Post;
import main.java.lld.newsfeedlowleveldesign.models.User;
import main.java.lld.newsfeedlowleveldesign.service.UserService;
import main.java.lld.newsfeedlowleveldesign.service.sortingStrategy.NewsFeedSortingStrategy;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class UserController {

    private final UserService userService;
    private NewsFeedSortingStrategy newsFeedSortingStrategy;

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

    public String follow(String email, Map<String,User> userMap){
        return userService.followUser(email, userMap);
    }

    public List<ResponsePostDto> shownewsfeed(String sortingStrategy, List<Post> allPosts){
        newsFeedSortingStrategy = SortStrategyFactory.getSortStrategy(sortingStrategy);
        if (newsFeedSortingStrategy == null) return null;
        newsFeedSortingStrategy.sortNewsFeed(allPosts);
        List<ResponsePostDto> responsePostDtos = new ArrayList<>();
        for(Post post : allPosts){
            responsePostDtos.add(mapDtoToPost(post));
        }
        return responsePostDtos;
    }

    private User mapDtoToUser(RequestUserDto requestUserDto){
        return User.Builder.getBuilder().setName(requestUserDto.getName()).setEmail(requestUserDto.getEmail())
                .setPassword(requestUserDto.getPassword()).setFollowing(requestUserDto.getFollowers())
                .setFollowing(requestUserDto.getFollowing()).build();
    }

    private ResponsePostDto mapDtoToPost(Post post){
        ResponsePostDto responsePostDto = new ResponsePostDto();
        responsePostDto.setTextPost(post.getText());
        responsePostDto.setUserName(post.getUser().getName());
        responsePostDto.setUpVotes(post.getUpVotes());
        responsePostDto.setDownVotes(post.getDownVotes());
        responsePostDto.setComments(post.getCommentList());
        responsePostDto.setTime(getTimeAgoString(post.getTimestamp()));
        return responsePostDto;
    }

    private String getTimeAgoString(Date timestamp) {
        Instant now = Instant.now();
        Duration duration = Duration.between(timestamp.toInstant(), now);
        if (duration.getSeconds() < 60) {
            return duration.getSeconds() + "s ago";
        } else if (duration.getSeconds() < 3600) {
            return duration.getSeconds() / 60 + "m ago";
        } else if (duration.getSeconds() < 86400) {
            return duration.getSeconds() / 3600 + "h ago";
        } else {
            return duration.getSeconds() / 86400 + "d ago";
        }
    }

}
