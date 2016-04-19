package com.goit.gojavaonline.tictactoe.model;

import com.goit.gojavaonline.tictactoe.view.ConsoleUserInteraction;
import com.goit.gojavaonline.tictactoe.view.UserInteraction;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;


/**
 * Created by tamila on 4/11/16.
 */
public class BoardTest {
    private static Board board;
    private static UserInteraction userInteraction;

    @BeforeClass
    public static void setUpClass() {
        board = new Board();
        userInteraction = new ConsoleUserInteraction();
    }

    private void setHorizontalLine(int rowNumber, CellContent cellContent) {
        board.clearBoard();
        for (int i = 0; i < board.getCells()[rowNumber].length; i++) {
            board.getCells()[rowNumber][i].setContent(cellContent);
        }
    }

    private void setVerticalLine(int columnNumber, CellContent cellContent) {
        board.clearBoard();
        for (int i = 0; i < board.getCells().length; i++) {
            board.getCells()[i][columnNumber].setContent(cellContent);
        }
    }

    private void setDiagonalLine1(CellContent cellContent) {
        board.clearBoard();
        for (int i = 0; i < board.getCells().length; i++) {
            board.getCells()[i][i].setContent(cellContent);
        }
    }

    private void setDiagonalLine2(CellContent cellContent) {
        board.clearBoard();
        int rowIndex = 0;
        for (int i = board.getCells().length - 1; i >= 0; i--) {
            board.getCells()[rowIndex++][i].setContent(cellContent);
        }
    }

    @Test
    public void testHorizontalLinesIsWin() throws Exception {
        for (int i = 0; i < board.getCells().length; i++) {
            setHorizontalLine(i, CellContent.CROSS);
            userInteraction.drawBoard(board);

            Assert.assertTrue(board.isWin(CellContent.CROSS));
            Assert.assertFalse(board.isWin(CellContent.ZERO));
        }
    }

    @Test
    public void testVerticalLinesIsWin() throws Exception {
        for (int i = 0; i < board.getCells()[0].length; i++) {
            setVerticalLine(i, CellContent.CROSS);
            userInteraction.drawBoard(board);

            Assert.assertTrue(board.isWin(CellContent.CROSS));
            Assert.assertFalse(board.isWin(CellContent.ZERO));
        }
    }

    @Test
    public void testDiagonalLinesIsWin() throws Exception {
        setDiagonalLine1(CellContent.CROSS);
        userInteraction.drawBoard(board);
        Assert.assertTrue(board.isWin(CellContent.CROSS));
        Assert.assertFalse(board.isWin(CellContent.ZERO));

        setDiagonalLine2(CellContent.CROSS);
        userInteraction.drawBoard(board);
        Assert.assertTrue(board.isWin(CellContent.CROSS));
        Assert.assertFalse(board.isWin(CellContent.ZERO));
    }

    @Test
    public void clearBoard() throws Exception {
        for (int i = 0; i < Board.DIMENSION; i++) {
            board.setUpCellContent(i, i, CellContent.CROSS);
        }

        board.clearBoard();

        for (int i = 0; i < Board.DIMENSION; i++) {
            for (int j = 0; j < Board.DIMENSION; j++) {
                Assert.assertEquals(CellContent.EMPTY, board.getCells()[i][j].getContent());
            }
        }


    }

    @Test
    public void getEmptyCells() throws Exception {
        board.clearBoard();
        board.setUpCellContent(0, 0, CellContent.CROSS);
        board.setUpCellContent(1, 1, CellContent.ZERO);
        board.setUpCellContent(2, 2, CellContent.EMPTY);

        List<Cell> emptyCells = board.getEmptyCells();

        Assert.assertNotNull(emptyCells);
        Assert.assertEquals("size of list is wrong", (Board.DIMENSION * Board.DIMENSION) - 2, emptyCells.size());
    }

    @Test
    public void isCellEmpty() throws Exception {
        board.clearBoard();
        board.setUpCellContent(0, 0, CellContent.CROSS);
        board.setUpCellContent(0, 1, CellContent.ZERO);

        Assert.assertEquals("assert_1", false, board.isCellEmpty(0, 0));
        Assert.assertEquals("assert_2", false, board.isCellEmpty(0, 1));
        Assert.assertEquals("assert_3", true, board.isCellEmpty(1, 1));
        Assert.assertEquals("assert_4", true, board.isCellEmpty(2, 2));

    }

    @Test
    public void hasEmptyCell() throws Exception {
        for (int i = 0; i < board.DIMENSION; i++) {
            for (int j = 0; j < board.DIMENSION; j++) {
                board.getCells()[i][j].setContent(CellContent.CROSS);
            }
        }
        Assert.assertFalse("filled board is passed", board.hasEmptyCell());

        board.getCells()[2][2].setContent(CellContent.EMPTY);
        Assert.assertTrue("one cell is empty", board.hasEmptyCell());

        board.clearBoard();
        Assert.assertTrue("empty board is passed", board.hasEmptyCell());

        board.getCells()[2][2].setContent(CellContent.ZERO);
        Assert.assertTrue("one cell is filled", board.hasEmptyCell());
    }

    @Test
    public void toStringTest() throws Exception {
        board.clearBoard();

        board.getCells()[1][1].setContent(CellContent.CROSS);

        StringBuilder stringBuilder = new StringBuilder();
        for (int row = 0; row < board.DIMENSION; ++row) {
            for (int col = 0; col < board.DIMENSION; ++col) {
                stringBuilder.append(board.getCells()[row][col].getCellContentDescription());
            }
            stringBuilder.append("\n");
        }
        stringBuilder.append("--------------------");

        Assert.assertTrue("compare toString", stringBuilder.toString().equals(board.toString()));

    }

    @Test
    public void setUpCellContent() throws Exception {
        board.clearBoard();

        board.getCells()[0][0].setContent(CellContent.ZERO);
        Assert.assertFalse("try to fill ZERO cell with CROSS", board.setUpCellContent(0, 0, CellContent.CROSS));

        board.getCells()[0][0].setContent(CellContent.EMPTY);
        Assert.assertTrue("try to fill EMPTY cell with CROSS", board.setUpCellContent(0, 0, CellContent.CROSS));

    }


}



