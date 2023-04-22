package main.java.lld.newsfeedlowleveldesign.controller.factory;

import main.java.lld.newsfeedlowleveldesign.service.sortingStrategy.*;

public class SortStrategyFactory {
    public static NewsFeedSortingStrategy getSortStrategy(String sortingStrategy){
        switch (sortingStrategy) {
            case "SortByFollowedUsers" -> {
                return new SortByFollowedUsers();
            } case "SortByNumComments" -> {
                return new SortByNumComments();
            } case "SortByScore" -> {
                return new SortByScore();
            } case "SortByTimestamp" -> {
                return new SortByTimestamp();
            } default -> {
                System.out.println("PLEASE PROVIDE A VALID STRATEGY");
                return null;
            }
        }
    }
}
