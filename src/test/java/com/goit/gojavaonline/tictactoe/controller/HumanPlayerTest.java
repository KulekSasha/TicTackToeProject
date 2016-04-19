package com.goit.gojavaonline.tictactoe.controller;

import com.goit.gojavaonline.tictactoe.input.UserInput;
import com.goit.gojavaonline.tictactoe.model.Board;
import com.goit.gojavaonline.tictactoe.model.CellContent;
import com.goit.gojavaonline.tictactoe.view.ConsoleUserInteraction;
import com.goit.gojavaonline.tictactoe.view.UserInteraction;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.mockito.Mockito.*;

/**
 * Created by tamila on 4/15/16.
 */
public class HumanPlayerTest {

    private static HumanPlayer humanPlayer;
    private static Board board;
    private static UserInteraction userInteraction;

    @BeforeClass
    public static void setUpClass() {
        board = new Board();
        userInteraction = new ConsoleUserInteraction();
        humanPlayer = new HumanPlayer(board, CellContent.CROSS);
    }

    @Test
    public void testGetNextMove() throws Exception {

        int expectedRow = 0;
        int expectedColumn = 1;

        UserInput row = mock(UserInput.class);
        when(row.getMovingIndex("row")).thenReturn(expectedRow);

        UserInput column = mock(UserInput.class);
        when(column.getMovingIndex("column")).thenReturn(expectedColumn);

        humanPlayer.userInput = row;
        humanPlayer.userInput = column;
        PlayerMove playerMove = humanPlayer.getNextMove();

        PlayerMove expectedPlayerMove = new PlayerMove(0, 0, 1);
        Assert.assertTrue(playerMove.equalsMoveCell(expectedPlayerMove));

    }
}