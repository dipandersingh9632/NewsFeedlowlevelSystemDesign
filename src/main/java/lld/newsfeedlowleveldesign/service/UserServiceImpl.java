package main.java.lld.newsfeedlowleveldesign.service;

import main.java.lld.newsfeedlowleveldesign.models.User;
import main.java.lld.newsfeedlowleveldesign.session.SessionManager;
import java.util.Map;

public class UserServiceImpl implements UserService{

    @Override
    public String createUser(User user, Map<String, User> userMap) {
        if(userMap.containsKey(user.getEmail())){
            return "USER ALREADY EXISTS WITH THIS EMAIL";
        }
        // save the USER
        userMap.put(user.getEmail(), user);
        return "USER SUCCESSFULLY SIGNED UP";
    }

    @Override
    public String loginUser(String email, String password, Map<String,User> userMap){
        if(!userMap.containsKey(email)) return "USER DOES NOT EXIST WITH THIS EMAIL " + email;
        User currUser = userMap.get(email);
        if(currUser.getPassword().compareTo(password) == 0){
            SessionManager.setLoggedInUser(currUser);
            return "USER LOGGED IN";
        }
        else return "PASSWORD IS NOT CORRECT";
    }

    @Override
    public String followUser(String email, Map<String, User> userMap) {
        if(SessionManager.getLoggedInUser() == null) return "LOGIN FIRST";
        if(!userMap.containsKey(email)) return "Followed User does not exist Enter correct email id";
        User loggedInUser = SessionManager.getLoggedInUser();
        User followedUser = userMap.get(email);
        loggedInUser.getFollowers().add(followedUser);
        followedUser.getFollowing().add(loggedInUser);
        return "SUCCESSFULLY FOLLOWED " + email;
    }
}
