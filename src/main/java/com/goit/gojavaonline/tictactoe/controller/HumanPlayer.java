package com.goit.gojavaonline.tictactoe.controller;

import com.goit.gojavaonline.tictactoe.exceptions.NegativeIntegerInputException;
import com.goit.gojavaonline.tictactoe.exceptions.TooFarFromRangeException;
import com.goit.gojavaonline.tictactoe.input.UserInput;
import com.goit.gojavaonline.tictactoe.model.Board;
import com.goit.gojavaonline.tictactoe.model.CellContent;
import com.goit.gojavaonline.tictactoe.view.UserInteraction;
import com.goit.gojavaonline.tictactoe.view.UserInteractionRepository;

/**
 * Created by SashaKulek on 07/04/2016.
 */

public class HumanPlayer extends Player {
    private static UserInteraction userInteraction = UserInteractionRepository.getDefaultUserInteraction();

    public HumanPlayer(Board board, CellContent playerSide) {
        super(board, playerSide);
    }

    UserInput userInput = new UserInput();

    @Override
    public PlayerMove getNextMove() {

        int row;
        int column;


        while(true){
            userInteraction.say("Please, make your move:");
            try{
                row = userInput.getMovingIndex( "row");
                column = userInput.getMovingIndex( "column");
                if(!super.board.isCellEmpty(row,column)){
                    userInteraction.sayError("The cell is not empty. Please select other cell.");
                }else {
                    break;
                }
            } catch (NegativeIntegerInputException | TooFarFromRangeException exception){
                userInteraction.sayError(exception.getMessage());
            }
        }

        return new PlayerMove(0, row, column);
    }

}
