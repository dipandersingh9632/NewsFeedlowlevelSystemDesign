package main.java.lld.newsfeedlowleveldesign;

import main.java.lld.newsfeedlowleveldesign.controller.UserController;
import main.java.lld.newsfeedlowleveldesign.dto.RequestUserDto;
import main.java.lld.newsfeedlowleveldesign.models.User;
import main.java.lld.newsfeedlowleveldesign.service.UserService;
import main.java.lld.newsfeedlowleveldesign.service.UserServiceImpl;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, User> users = new HashMap<>();
        UserService userService = new UserServiceImpl();
        UserController userController = new UserController(userService);


        RequestUserDto requestUserDto = new RequestUserDto();
        requestUserDto.setName("Depandre singh");
        requestUserDto.setEmail("d@gmail.com");
        requestUserDto.setPassword("123");
        System.out.println(userController.signup(requestUserDto, users));

        System.out.println(userController.login("d@gmail.com", "123", users));





    }
}
