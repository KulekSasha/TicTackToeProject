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
    public PlayerMove getNextMoves() {
        return minimax(1, this.playerSide); // TODO: 13/04/2016 why first argument "1", move to minimax method
    }


    private PlayerMove minimax(int depth, CellContent player) {
        List<Cell> emptyCells = this.board.getEmptyCells();


        PlayerMove tmpMove = new PlayerMove();
        PlayerMove resultMove = new PlayerMove();
        resultMove.setDepth(this.playerSide == player? Integer.MIN_VALUE : Integer.MAX_VALUE); //best score

        if (board.isWin(player)) {
            if (playerSide == player) {
                return new PlayerMove(depth + 10, 0, 0);
            } else {
                return new PlayerMove(depth - 10, 0, 0);
            }
        } else if (!board.hasEmptyCell()) {
            return new PlayerMove(0, 0, 0);
        }

        for (Cell cell : emptyCells) {
            cell.setContent(player);

            if (playerSide == player) {
                tmpMove.setDepth(minimax(depth + 1, oppositePlayer).getDepth());
                if (tmpMove.getDepth() > resultMove.getDepth()) {
                    resultMove.setMove(tmpMove.getDepth(), cell.getRow(), cell.getCol());
                }
            } else {
                tmpMove.setDepth( minimax(depth + 1, playerSide).getDepth());
                if (tmpMove.getDepth() < resultMove.getDepth()) {
                    resultMove.setMove(tmpMove.getDepth(), tmpMove.getRow(), tmpMove.getColumn());
                }
            }
            cell.setContent(CellContent.EMPTY);
        }
        return resultMove;
    }

    private CellContent getOppositePlayer(CellContent player) {
        return player == CellContent.CROSS ? CellContent.ZERO : CellContent.CROSS;
    }
}
