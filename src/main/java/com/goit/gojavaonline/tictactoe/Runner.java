package com.goit.gojavaonline.tictactoe;

import com.goit.gojavaonline.tictactoe.model.Board;
import com.goit.gojavaonline.tictactoe.view.UserInteractionRepository;

/**
 * Created by SashaKulek on 08/04/2016.
 */

public class Runner {
    public static void main(String[] args) {
        Board b = new Board();
        Game game = new Game(b, UserInteractionRepository.getDefaultUserInteraction());
        game.startGame();
    }
}
