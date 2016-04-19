package com.goit.gojavaonline.tictactoe;

import com.goit.gojavaonline.tictactoe.controller.AiMinMaxPlayer;
import com.goit.gojavaonline.tictactoe.controller.HumanPlayer;
import com.goit.gojavaonline.tictactoe.controller.Player;
import com.goit.gojavaonline.tictactoe.controller.PlayerMove;
import com.goit.gojavaonline.tictactoe.model.Board;
import com.goit.gojavaonline.tictactoe.model.CellContent;
import com.goit.gojavaonline.tictactoe.view.UserInteraction;

/**
 * Created by SashaKulek on 07/04/2016.
 */

public class Game {
    private Board board;
    private Player playerCross;
    private Player playerZero;
    private GameState gameState;
    private UserInteraction userInteraction;

    public Game(Board board, UserInteraction userInteraction)  {
        if(board == null){
            throw new IllegalArgumentException("Board parameter must not be null");
        } else if(!board.isBoardClear()){
            throw new IllegalArgumentException("Board cells shouldn't be filled");
        }
        if(userInteraction == null){
            throw new IllegalArgumentException("User Interaction parameter must not be null");
        }

        this.board = board;
        this.userInteraction = userInteraction;
    }

    private void initializePlayers(Player playerCross, Player playerZero){
        this.playerCross = playerCross;
        this.playerZero = playerZero;
    }

    public void startGame(){
        int turn = 1;
        gameState = GameState.PLAYING;
        PlayerMove nextMove;
        setUpPlayers();

        do {
            if (turn % 2 == 1) {
                nextMove = playerCross.getNextMove();
                board.setUpCellContent(nextMove.getRow(), nextMove.getColumn(), playerCross.getPlayerSide());
            } else {
                nextMove = playerZero.getNextMove();
                board.setUpCellContent(nextMove.getRow(), nextMove.getColumn(), playerZero.getPlayerSide());
            }
            userInteraction.drawBoard(board);
            turn++;
            gameState = updateGameStatus();
        } while (gameState == GameState.PLAYING);
        userInteraction.say( getGameResult() );
        playAgain();
    }

    public String getGameResult() {
        if (gameState == GameState.DRAW) {
            return gameState.toString();
        } else {
            return gameState.toString();
        }
    }


    private void setUpPlayers() {
        userInteraction.say("Welcome to a tick-tack-toe game!\n" +
                "What do you prefer to play with: crosses or zeroes (type CROSS or ZERO, QUIT for quit)\n");

        while(true){
            String input = userInteraction.ask("Please, make your choice: ");
            if ("CROSS".equals(input)) {
                initializePlayers(new HumanPlayer(board, CellContent.CROSS),
                        new AiMinMaxPlayer(board, CellContent.ZERO));
                userInteraction.drawBoard(board);
                break;
            } else if ("ZERO".equals(input)) {
                initializePlayers(new AiMinMaxPlayer(board, CellContent.CROSS),
                        new HumanPlayer(board, CellContent.ZERO));
                break;
            } else if ("QUIT".equals(input)) {
                userInteraction.endGame();
            }
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

    private void playAgain(){
        if(userInteraction.ask("Do you want to play once more?\n'Y' - yes\n'any key' - no\n").equals("Y")){
            board.clearBoard();
            startGame();
        }
    }
}

enum GameState {
    PLAYING, DRAW, CROSS_WIN, ZERO_WIN
}
