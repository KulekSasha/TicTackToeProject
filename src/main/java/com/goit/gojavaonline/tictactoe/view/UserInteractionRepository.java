package com.goit.gojavaonline.tictactoe.view;

/**
 * Created by tamila on 4/18/16.
 */
public class UserInteractionRepository {
    private static UserInteraction userInteraction;
    public static UserInteraction getDefaultUserInteraction(){
        if(userInteraction == null){
            userInteraction = new ConsoleUserInteraction();
        }
        return userInteraction;
    }
}
