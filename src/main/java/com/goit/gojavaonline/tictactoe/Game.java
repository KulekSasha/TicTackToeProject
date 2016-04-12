package com.goit.gojavaonline.tictactoe;

import java.util.Scanner;

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
        setUpPlayers();
        gameState = GameState.PLAYING;

        int[] tmp = new int[2];
        int[] tmp2 = new int[2];

        do {
            int[] crossNextMoves = playerCross.getNextMoves();
            board.getCells()[crossNextMoves[0]][crossNextMoves[1]].setContent(playerCross.getPlayerSide());
            board.print();

            if(board.isWin(CellContent.CROSS)){
                gameState= GameState.CROSS_WIN;
                break;
            } else if(!board.hasEmptyCell()){
                gameState = GameState.DRAW;
                break;
            }

            int[] zeroNextMoves = playerZero.getNextMoves();
            board.getCells()[zeroNextMoves[0]][zeroNextMoves[1]].setContent(playerZero.getPlayerSide());
            board.print();

            if(board.isWin(CellContent.ZERO)){
                gameState = GameState.ZERO_WIN;
                break;
            } else if(!board.hasEmptyCell()){
                gameState = GameState.DRAW;
                break;
            }

        } while (gameState == GameState.PLAYING);

        }

    public String getGameResult(){
        if(gameState == GameState.DRAW){
            return gameState.toString();
        } else {
            return gameState.toString() + " won!";
        }
    }


    private void setUpPlayers() {

        //ask user about side
        CellContent answer = null;
        boolean iterator = true;

        System.out.println("Welcome to a tick-tack-toe game!\n" +
                "What do you prefer to play with: crosses or zeroes (type CROSS or ZERO, QUIT for quit)\n");

        while (iterator) {

            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            if ("CROSS".equals(input)) {
                answer = CellContent.CROSS;
                break;

            } else if ("ZERO".equals(input)) {
                answer = CellContent.ZERO;
                break;

            } else if ("QUIT".equals(input)){
                System.exit(0);

            } else {
                System.out.println("Please, make your choice");
            }
        }

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
