package com.goit.gojavaonline.tictactoe.view;

import com.goit.gojavaonline.tictactoe.model.Board;

/**
 * Created by tamila on 4/18/16.
 */
public interface UserInteraction {
    void say(String message);
    void drawBoard(Board board);
    void sayError(String message);
    String ask(String message);
    void endGame();
}
