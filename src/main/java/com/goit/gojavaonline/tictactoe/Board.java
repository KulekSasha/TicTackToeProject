package com.goit.gojavaonline.tictactoe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SashaKulek on 07/04/2016.
 */

public class Board {
    public static final int ROWS = 3;
    public static final int COLS = 3;



    Cell[][] cells;

    public Board() {
        cells = new Cell[ROWS][COLS];

        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                cells[row][col] = new Cell(row, col);
            }
        }
    }

    public void clearBoard() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                cells[row][col].setContent(CellContent.EMPTY);
            }
        }
    }

    public List<Cell> getEmptyCells() {
        List<Cell> listEmptyCells = new ArrayList<>();

        for (int row = 0; row < ROWS; ++row) {
            for (int col = 0; col < COLS; ++col) {
                if (cells[row][col].getContent() == CellContent.EMPTY) {
                    listEmptyCells.add(cells[row][col]);
                }
            }
        }
        return listEmptyCells;
    }

    private boolean hasHorizontalLine(CellContent cellContent){
        boolean hasLine = true;
        for(int row = 0; row < ROWS; row++){
            hasLine = true;
            for(int col = 0; col < COLS; col++){
                //System.out.println("cells[ "+row +" ][ "+ col + " ] == " + cells[row][col].getContent());
                if(cells[row][col].getContent() != cellContent){
                    hasLine = false;
                    break;
                }
            }
            if(hasLine){
                break;
            }
        }
        return hasLine;
    }

    private boolean hasVerticalLine(CellContent cellContent){
        boolean hasLine = true;
        for(int col = 0; col < COLS; col++){
            hasLine = true;
            for(int row = 0; row < ROWS; row++){
                if(cells[row][col].getContent() != cellContent){
                    hasLine = false;
                    break;
                }
            }
            if(hasLine){
                break;
            }
        }
        return hasLine;
    }

    private boolean hasDiagonalLine(CellContent cellContent){
        boolean hasDiagonalLine = true;
        for(int cellIndex = 0; cellIndex < Math.min(ROWS, COLS); cellIndex++){
            hasDiagonalLine = cells[cellIndex][cellIndex].getContent() == cellContent;
            if (!hasDiagonalLine){
                break;
            }
        }
        if(hasDiagonalLine){
            return true;
        }
        int rowIndex = 0;
        for(int colIndex = Math.min(ROWS, COLS)-1; colIndex >= 0; colIndex--){
            hasDiagonalLine = cells[rowIndex++][colIndex].getContent() == cellContent;
            if (!hasDiagonalLine){
                break;
            }
        }
        return hasDiagonalLine;
    }

    public boolean isWin(CellContent playerSide) {
        return hasHorizontalLine(playerSide) || hasVerticalLine(playerSide) || hasDiagonalLine(playerSide);
    }

    public boolean hasEmptyCell(){
        for (int row = 0; row < ROWS; ++row) {
            for (int col = 0; col < COLS; ++col) {
                if (cells[row][col].getContent() == CellContent.EMPTY) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    protected Board clone()  {
        Board copyBoard = new Board();

        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                copyBoard.cells[row][col].setContent(this.cells[row][col].getContent());
            }
        }
        return copyBoard;
    }

    public void print(){
        for (int row = 0; row < ROWS; ++row) {
            for (int col = 0; col < COLS; ++col) {
                cells[row][col].paint();
            }
            System.out.println();
        }
        System.out.println("--------------------");
    }
}
