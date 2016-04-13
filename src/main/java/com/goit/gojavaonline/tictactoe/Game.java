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
    private Scanner scanner = new Scanner(System.in);

    public Game(Board board) {
        this.board = board;
    }


    public void startGame() {
        int turn = 1;
        gameState = GameState.PLAYING;
        int[] nextMove;// = null;
        setUpPlayers();

        do {
            if (turn % 2 == 1) {
                nextMove = playerCross.getNextMoves();
                board.setUpCellContent(nextMove[0], nextMove[1], playerCross.getPlayerSide());
            } else {
                nextMove = playerZero.getNextMoves();
                board.setUpCellContent(nextMove[0], nextMove[1], playerZero.getPlayerSide());
            }
            board.print();
            turn++;
            gameState = updateGameStatus();
        } while (gameState == GameState.PLAYING);
        System.out.println(getGameResult());
        playAgain();
    }

    public String getGameResult() {
        if (gameState == GameState.DRAW) {
            return gameState.toString();
        } else {
            return gameState.toString() + " won!";
        }
    }

    private void setUpPlayers() {
        CellContent answer = null;
        boolean iterator = true;

        System.out.println("Welcome to a tick-tack-toe game!\n" +
                "What do you prefer to play with: crosses or zeroes (type CROSS or ZERO, QUIT for quit)\n");

        while (iterator) {
            String input = scanner.nextLine().toUpperCase();
            if ("CROSS".equals(input)) {
                answer = CellContent.CROSS;
                break;
            } else if ("ZERO".equals(input)) {
                answer = CellContent.ZERO;
                break;
            } else if ("QUIT".equals(input)) {
                System.exit(0);
            } else {
                System.out.println("Please, make your choice");
            }
        }

        if (answer == CellContent.CROSS) {
            playerCross = new HumanPlayer(board, CellContent.CROSS);
            playerZero = new AiMinMaxPlayer(board, CellContent.ZERO);
            board.print();
        } else if (answer == CellContent.ZERO) {
            playerCross = new AiMinMaxPlayer(board, CellContent.CROSS);
            playerZero = new HumanPlayer(board, CellContent.ZERO);
        }
    }

    private GameState updateGameStatus() {
        if (board.isWin(CellContent.CROSS)) {
            return GameState.CROSS_WIN;
        } else if (board.isWin(CellContent.ZERO)) {
            return GameState.ZERO_WIN;
        } else if (board.getEmptyCells().size() == 0) {
            return GameState.DRAW;
        } else {
            return GameState.PLAYING;
        }
    }

    private void playAgain() {
        System.out.println("Dp you want to play once more?\n'Y' - yes\n'any key' - no");
        if (scanner.hasNext("y") || scanner.hasNext("Y")) {
            board.clearBoard();
            startGame();
        }
    }
}

enum GameState {
    PLAYING, DRAW, CROSS_WIN, ZERO_WIN
}
