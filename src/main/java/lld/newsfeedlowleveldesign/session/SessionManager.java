package main.java.lld.newsfeedlowleveldesign.session;

import main.java.lld.newsfeedlowleveldesign.models.User;

public class SessionManager {
    private static User loggedInUser;

    public static User getLoggedInUser(){
        return loggedInUser;
    }

    public static void setLoggedInUser(User user){
        loggedInUser = user;
    }
}
