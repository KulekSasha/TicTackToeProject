package com.goit.gojavaonline.tictactoe;

/**
 * Created by SashaKulek on 07/04/2016.
 */

public class HumanPlayer extends Player {
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

    public HumanPlayer(Board board, CellContent playerSide) {
        super(board, playerSide);
    }

    @Override
    public PlayerMove getNextMoves() {

        int row;
        int column;
        while(true){
            userInteraction.say("Please, make your move:");
            try{
                row = getMovingIndex( "row");
                column = getMovingIndex( "column");
                break;
            } catch (NegativeIntegerInputException | TooFarFromRangeException exception){
                userInteraction.sayError(exception.getMessage());
            }
        }

        return new PlayerMove(0, row, column);
    }

    private int getMovingIndex(String argument) throws NegativeIntegerInputException, TooFarFromRangeException {
        int input = readInt(argument) - 1;

        if(input < 0){
            throw new NegativeIntegerInputException("You should enter an Integer value which is above zero\n");
        } else if(input >= Board.DIMENSION){
            throw new TooFarFromRangeException(input, "Your " + argument + "\'s value should be less then " + Board.DIMENSION + "\n");
        }
        return input;
    }


}
