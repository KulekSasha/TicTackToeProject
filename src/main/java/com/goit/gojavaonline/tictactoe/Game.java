package com.goit.gojavaonline.tictactoe;

/**
 * Created by SashaKulek on 07/04/2016.
 */

public class Game {
    private Board board;
    private Player playerCross;
    private Player playerZero;
    private GameState gameState;


    public Game(Board board) {
        this.board = board;
    }


    public void startGame() {
        setUpPleers(); //now cross player = AI
        gameState = GameState.PLAYING;

        int[] tmp = new int[2];
        int[] tmp2 = new int[2];

        do {
            int[] crossNextMoves = playerCross.getNextMoves();
            board.cells[crossNextMoves[0]][crossNextMoves[1]].setContent(playerCross.getPlayerSide());
            board.print();

            if(board.isWin(CellContent.CROSS)){
                gameState= GameState.CROSS_WIN;
                break;
            }

            int[] zeroNextMoves = playerZero.getNextMoves();
            board.cells[zeroNextMoves[0]][zeroNextMoves[1]].setContent(playerZero.getPlayerSide());
            board.print();

            if(board.isWin(CellContent.ZERO)){
                gameState = GameState.ZERO_WIN;
                break;
            }

        } while (gameState == GameState.PLAYING);
        System.out.println(gameState.toString() + " win buy");

    }


    private void setUpPleers() {
        //ask user about side
        CellContent answer = CellContent.ZERO;
        //--------------

        if (answer == CellContent.CROSS) {
            playerCross = new HumanPlayer(board, CellContent.CROSS);
            playerZero = new AiMinMaxPlayer(board, CellContent.ZERO);
        } else if (answer == CellContent.ZERO) {
            playerCross = new AiMinMaxPlayer(board, CellContent.CROSS);
            playerZero = new HumanPlayer(board, CellContent.ZERO);
        }
    }

    private void gameStatus() {
        if (board.isWin(CellContent.CROSS)) {
            gameState = GameState.CROSS_WIN;
        } else if (board.isWin(CellContent.ZERO)) {
            gameState = GameState.ZERO_WIN;
        } else if (board.getEmptyCells().size() == 0) {
            gameState = GameState.DRAW;
        } else {
            gameState = GameState.PLAYING;
        }
    }

}

enum GameState {
    PLAYING, DRAW, CROSS_WIN, ZERO_WIN
}
