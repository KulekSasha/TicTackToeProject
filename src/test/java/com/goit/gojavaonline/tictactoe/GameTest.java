package com.goit.gojavaonline.tictactoe;

import com.goit.gojavaonline.tictactoe.model.Board;
import com.goit.gojavaonline.tictactoe.model.CellContent;
import com.goit.gojavaonline.tictactoe.view.ConsoleUserInteraction;
import com.goit.gojavaonline.tictactoe.view.UserInteraction;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by tamila on 4/19/16.
 */
public class GameTest {
    private static Board board;
    private static UserInteraction userInteraction;
    private static Game game;

    @BeforeClass
    public static void setUpClass() {
        board = new Board();
        board.setUpCellContent(0, 0, CellContent.CROSS);
        board.setUpCellContent(1, 1, CellContent.ZERO);
        board.setUpCellContent(2, 2, CellContent.EMPTY);
        userInteraction = new ConsoleUserInteraction();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateGame_dirtyBoard(){
        game = new Game(board, userInteraction);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateGame_nullBoard(){
        game = new Game(null, userInteraction);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateGame_nullUserInteraction(){
        game = new Game(new Board(), null);
    }
}