package com.goit.gojavaonline.tictactoe;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 * Created by tamila on 4/11/16.
 */
public class BoardTest {

    private static Board board;
    private static UserInteraction userInteraction;

    @BeforeClass
    public static void setUpClass(){
        board = new Board();
        userInteraction = new ConsoleUserInteraction();
    }

    private void setHorizontalLine(int rowNumber, CellContent cellContent){
        board.clearBoard();
        for (int i = 0; i < board.getCells()[rowNumber].length; i++){
            board.getCells()[rowNumber][i].setContent(cellContent);
        }
    }
    private void setVerticalLine(int columnNumber, CellContent cellContent){
        board.clearBoard();
        for(int i = 0; i < board.getCells().length; i++){
            board.getCells()[i][columnNumber].setContent(cellContent);
        }
    }

    private void setDiagonalLine1(CellContent cellContent){
        board.clearBoard();
        for(int i = 0; i < board.getCells().length; i++){
            board.getCells()[i][i].setContent(cellContent);
        }
    }

    private void setDiagonalLine2(CellContent cellContent){
        board.clearBoard();
        int rowIndex = 0;
        for(int i = board.getCells().length - 1; i >= 0; i--){
            board.getCells()[rowIndex++][i].setContent(cellContent);
        }
    }

    @Test
    public void testHorizontalLinesIsWin() throws Exception {
        for(int i = 0; i < board.getCells().length; i++){
            setHorizontalLine(i, CellContent.CROSS);
            userInteraction.drawBoard(board);

            Assert.assertTrue(board.isWin(CellContent.CROSS));
            Assert.assertFalse(board.isWin(CellContent.ZERO));
        }
    }


    @Test
    public void testVerticalLinesIsWin() throws Exception {
        for(int i = 0; i < board.getCells()[0].length; i++){
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
        for (int i = 0; i < board.DIMENSION; i++) {
            board.setUpCellContent(i,i,CellContent.CROSS);
        }

        board.clearBoard();

        for (int i = 0; i < board.DIMENSION; i++) {
            for (int j = 0; j < board.DIMENSION; j++) {
                Assert.assertEquals(CellContent.EMPTY,board.getCells()[i][j].getContent());
            }
        }


    }


}



