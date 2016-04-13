package com.goit.gojavaonline.tictactoe;

/**
 * Created by SashaKulek on 07/04/2016.
 */

public abstract class Player {
     CellContent playerSide;
     Board board;


    public Player(Board board, CellContent playerSide) {
        this.board = board;
        this.playerSide = playerSide;
    }

    public abstract PlayerMove getNextMoves();

    public CellContent getPlayerSide() {
        return playerSide;
    }
}