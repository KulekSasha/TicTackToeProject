package com.goit.gojavaonline.tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by SashaKulek on 07/04/2016.
 */

public class HumanPlayer extends Player {

    private static final int BOARD_SIZE = 3;

    private static int readInt(String input){
        while(true) {
            try {
                Scanner scanner = new Scanner(System.in);
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("You have to print Integer " + input + "'s value" );
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


            if (row >= BOARD_SIZE || column >= BOARD_SIZE) {
                try {
                    throw new TooFarFromRangeException(row);

                } catch (TooFarFromRangeException e) {

                    System.out.println("Your row's or column's value should be less then " + BOARD_SIZE);
                    row = 0;
                    column = 0;
                }
            }

        } while (!isEmptyCell(row, column));
        return new int[]{row, column};
    }

    private boolean isEmptyCell(int row, int col) {
        return board.getCells()[row][col].getContent() == CellContent.EMPTY ? true : false;
    }
}
