package com.goit.gojavaonline.tictactoe.controller;

import com.goit.gojavaonline.tictactoe.model.Board;
import com.goit.gojavaonline.tictactoe.model.CellContent;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by tamila on 4/12/16.
 */
public class AiMinMaxPlayerTest {

    private static AiMinMaxPlayer aiMinMaxPlayer;
    private static Board board;

    @BeforeClass
    public static void setUpClass() {
        board = new Board();
        aiMinMaxPlayer = new AiMinMaxPlayer(board, CellContent.ZERO);
    }

    @Before
    public void setUp() throws Exception {
        board.clearBoard();
    }

    @Test
    public void testGetNextCrossMove() throws Exception {
        board.setUpCellContent(0, 0, CellContent.CROSS);
        board.setUpCellContent(1, 0, CellContent.CROSS);
        board.setUpCellContent(1, 1, CellContent.CROSS);
        board.setUpCellContent(0, 1, CellContent.ZERO);
        board.setUpCellContent(1, 2, CellContent.ZERO);
        board.setUpCellContent(2, 2, CellContent.ZERO);

        PlayerMove expectedPlayerMove = new PlayerMove(0, 2, 0);

        PlayerMove playerMove = aiMinMaxPlayer.getNextMove();

        Assert.assertTrue(playerMove.equalsMoveCell(expectedPlayerMove));
    }

    @Test
    public void testGetNextZeroMove1() throws Exception {
        board.setUpCellContent(0, 0, CellContent.ZERO);
        board.setUpCellContent(1, 0, CellContent.ZERO);
        board.setUpCellContent(1, 1, CellContent.ZERO);
        board.setUpCellContent(0, 1, CellContent.CROSS);
        board.setUpCellContent(1, 2, CellContent.CROSS);
        board.setUpCellContent(2, 2, CellContent.CROSS);

        PlayerMove expectedPlayerMove = new PlayerMove(0, 0, 2);

        PlayerMove playerMove = aiMinMaxPlayer.getNextMove();

        Assert.assertFalse(playerMove.equalsMoveCell(expectedPlayerMove));
    }

    @Test
    public void testGetNextZeroMove2() throws Exception {
        board.setUpCellContent(0, 0, CellContent.CROSS);
        board.setUpCellContent(0, 1, CellContent.CROSS);
        board.setUpCellContent(1, 1, CellContent.ZERO);

        PlayerMove expectedPlayerMove = new PlayerMove(0, 0, 2);

        PlayerMove playerMove = aiMinMaxPlayer.getNextMove();

        Assert.assertTrue(playerMove.equalsMoveCell(expectedPlayerMove));
    }
}