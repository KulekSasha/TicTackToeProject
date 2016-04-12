package com.goit.gojavaonline.tictactoe;

import java.util.Scanner;

/**
 * Created by SashaKulek on 07/04/2016.
 */

public class HumanPlayer extends Player {


    public HumanPlayer(Board board, CellContent playerSide) {
        super(board, playerSide);
    }

    @Override
    public int[] getNextMoves() {
        Scanner scanner = new Scanner(System.in);

        int row = 0;
        int col = 0;
        do {
            System.out.println("plz enter:");
            row = scanner.nextInt()-1;
            col = scanner.nextInt()-1;
        } while (!isEmptyCell(row, col));
        return new int[]{row, col};
    }

    private boolean isEmptyCell(int row, int col) {
        return board.getCells()[row][col].getContent() == CellContent.EMPTY ? true : false;
    }
}
