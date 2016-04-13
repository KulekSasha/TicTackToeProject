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
            row = readInt("row") - 1;

            System.out.print("column: ");
            column = readInt("column") - 1;

            if (row >= DIMENSION) {
                try {
                    throw new TooFarFromRangeException(row);

                } catch (TooFarFromRangeException e) {

                    System.out.print("Your row's value should be less then " + DIMENSION + "\nrow: ");
                    row = readInt("row") - 1;
                }
            }

            if (column >= DIMENSION) {
                try {
                    throw new TooFarFromRangeException(column);

                } catch (TooFarFromRangeException e) {

                    System.out.print("Your column's value should be less then " + DIMENSION + "\ncolumn: ");
                    column = readInt("column") - 1;
                }
            }

        } while (!isEmptyCell(row, column));
        return new int[]{row, column};
    }

    private boolean isEmptyCell(int row, int col) {
        return board.getCells()[row][col].getContent() == CellContent.EMPTY ? true : false;
    }
}
