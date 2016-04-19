package com.goit.gojavaonline.tictactoe.view;

import com.goit.gojavaonline.tictactoe.exceptions.NegativeIntegerInputException;
import com.goit.gojavaonline.tictactoe.exceptions.TooFarFromRangeException;
import com.goit.gojavaonline.tictactoe.model.Board;
import com.goit.gojavaonline.tictactoe.view.UserInteraction;
import com.goit.gojavaonline.tictactoe.view.UserInteractionRepository;

/**
 * Created by User on 19.04.2016.
 */
public class UserInput {

    private static UserInteraction userInteraction = UserInteractionRepository.getDefaultUserInteraction();

    private static int readInt(String input){
        while(true) {
            try {
                return Integer.parseInt( userInteraction.ask(input + ": ") );
            } catch (NumberFormatException e) {
                userInteraction.sayError("You have to print Integer value\n");
            }
        }
    }

    public int getMovingIndex(String argument) throws NegativeIntegerInputException, TooFarFromRangeException {
        int input = readInt(argument) - 1;

        if(input < 0){
            throw new NegativeIntegerInputException("You should enter an Integer value which is above zero\n");
        } else if(input >= Board.DIMENSION){
            throw new TooFarFromRangeException(input, "Your " + argument + "\'s value should be less then " + Board.DIMENSION + "\n");
        }
        return input;
    }

}

