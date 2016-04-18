package com.goit.gojavaonline.tictactoe;

/**
 * Created by SashaKulek on 08/04/2016.
 */

public class Runner {
    public static void main(String[] args) {
        Board b = new Board();
        UserInteraction userInteraction = new ConsoleUserInteraction();
        Game game = new Game(b, userInteraction);
        game.startGame();
    }
}
