package com.goit.gojavaonline.tictactoe;

import java.util.List;

/**
 * Created by SashaKulek on 07/04/2016.
 */

public class AiMinMaxPlayer extends Player {
    private CellContent oppositePlayer = getOppositePlayer(playerSide);

    public AiMinMaxPlayer(Board board, CellContent playerSide) {
        super(board, playerSide);
    }

    @Override
    public int[] getNextMoves() {
        int[] result = minimax(1, this.playerSide); // TODO: 13/04/2016 why first argument "1", move to minimax method
        return new int[]{result[1], result[2]};
    }


    private int[] minimax(int depth, CellContent player) {
        List<Cell> emptyCells = this.board.getEmptyCells();


        int[] tmp = new int[3];
        int[] result = new int[3];
        result[0] = (this.playerSide == player) ? Integer.MIN_VALUE : Integer.MAX_VALUE; //best score

        if (board.isWin(player)) {
            if (playerSide == player) {
                return new int[]{depth + 10};
            } else {
                return new int[]{depth - 10};
            }
        } else if (!board.hasEmptyCell()) {
            return new int[]{0};
        }

        for (Cell cell : emptyCells) {
            cell.setContent(player);

            if (playerSide == player) {
                tmp[0] = minimax(depth + 1, oppositePlayer)[0];
                if (tmp[0] > result[0]) {
                    result[0] = tmp[0];
                    result[1] = cell.getRow();
                    result[2] = cell.getCol();
                }
            } else if (playerSide != player) {
                tmp[0] = minimax(depth + 1, playerSide)[0];
                if (tmp[0] < result[0]) {
                    result[0] = tmp[0];
                    result[1] = tmp[1];
                    result[2] = tmp[2];
                }
            }
            cell.setContent(CellContent.EMPTY);
        }
        return result;
    }

    private CellContent getOppositePlayer(CellContent player) {
        return player == CellContent.CROSS ? CellContent.ZERO : CellContent.CROSS;
    }
}
