package com.goit.gojavaonline.tictactoe;

/**
 * Created by SashaKulek on 08/04/2016.
 */

public class Runner {
    public static void main(String[] args) {
        Board b = new Board();
        Game game = new Game(b);
        game.startGame();
        System.out.println(game.getGameResult()); // TODO: 13/04/2016 move this line to cass Game
    }
}
