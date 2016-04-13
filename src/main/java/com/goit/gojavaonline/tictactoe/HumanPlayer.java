package com.goit.gojavaonline.tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by SashaKulek on 07/04/2016.
 */

public class HumanPlayer extends Player {

    private static final int DIMENSION = 3;

    private static int readInt(String input){
        while(true) {
            try {
                Scanner scanner = new Scanner(System.in);
                return scanner.nextInt();

            } catch (InputMismatchException e) {
                System.out.print("You have to print Integer " + input + "'s value\n" + input + ": " );
            }
        }
    }

    public HumanPlayer(Board board, CellContent playerSide) {
        super(board, playerSide);
    }

    @Override
    public int[] getNextMoves() {

        int row;
        int column;
        do {
            System.out.println("Please, make your move:");

            System.out.print("row: ");
            row = getMovingIndex("row");

            System.out.print("column: ");
            column = getMovingIndex("column");

        } while (!isEmptyCell(row, column));
        return new int[]{row, column};
    }

    private int getMovingIndex(String argument) {

        int index = catchNegativeInput(argument);

        if (index >= DIMENSION) {

            while (index >= DIMENSION) {
                try {
                    throw new TooFarFromRangeException(index);

                } catch (TooFarFromRangeException e) {

                    System.out.print("Your " + argument + "\'s value should be less then " + DIMENSION + "\n" + argument + ": ");
                    index = catchNegativeInput(argument);
                }
            }
        }
        return index;
    }

    private int catchNegativeInput(String argument) {

        int input = readInt(argument) - 1;

        if (input < 0) {

            while (input < 0) {
                try {
                    throw new NegativeIntegerInputException("To good to be true");

                } catch (NegativeIntegerInputException e) {

                    System.out.print("You should enter an Integer value which is above zero\n" + argument + ": ");
                    input = readInt(argument) - 1;
                }
            }
        }
        return input;
    }

    private boolean isEmptyCell(int row, int col) {
        return board.getCells()[row][col].getContent() == CellContent.EMPTY ? true : false;
    }
}
