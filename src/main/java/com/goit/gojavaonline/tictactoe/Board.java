package com.goit.gojavaonline.tictactoe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SashaKulek on 07/04/2016.
 */

public class Board {
    private static final int DIMENSION = 3;

    private Cell[][] cells;

    public Board() {
        cells = new Cell[DIMENSION][DIMENSION];

        for (int row = 0; row < DIMENSION; row++) {
            for (int col = 0; col < DIMENSION; col++) {
                cells[row][col] = new Cell(row, col);
            }
        }
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void clearBoard() {
        for (int row = 0; row < DIMENSION; row++) {
            for (int col = 0; col < DIMENSION; col++) {
                cells[row][col].setContent(CellContent.EMPTY);
            }
        }
    }

    public List<Cell> getEmptyCells() {
        List<Cell> listEmptyCells = new ArrayList<>();

        for (int row = 0; row < DIMENSION; ++row) {
            for (int col = 0; col < DIMENSION; ++col) {
                if (cells[row][col].getContent() == CellContent.EMPTY) {
                    listEmptyCells.add(cells[row][col]);
                }
            }
        }
        return listEmptyCells;
    }

    private boolean hasLine(CellContent cellContent, LineDirection lineDirection) {
        if (lineDirection == LineDirection.DIAGONAL) {
            return hasDiagonalLine(cellContent);
        }
        boolean hasLine = true;
        for (int i = 0; i < DIMENSION; i++) {
            hasLine = true;
            for (int j = 0; j < DIMENSION; j++) {
                if (lineDirection == LineDirection.VERTICAL ?
                        cells[j][i].getContent() != cellContent : cells[i][j].getContent() != cellContent) {
                    hasLine = false;
                    break;
                }
            }
            if (hasLine) {
                break;
            }
        }
        return hasLine;
    }

    private boolean hasDiagonalLine(CellContent cellContent) {
        boolean hasDiagonalLine = true;
        for (int cellIndex = 0; cellIndex < DIMENSION; cellIndex++) {
            hasDiagonalLine = cells[cellIndex][cellIndex].getContent() == cellContent;
            if (!hasDiagonalLine) {
                break;
            }
        }
        if (hasDiagonalLine) {
            return true;
        }
        int rowIndex = 0;
        for (int colIndex = DIMENSION - 1; colIndex >= 0; colIndex--) {
            hasDiagonalLine = cells[rowIndex++][colIndex].getContent() == cellContent;
            if (!hasDiagonalLine) {
                break;
            }
        }
        return hasDiagonalLine;
    }

    public boolean isWin(CellContent playerSide) {
        return hasLine(playerSide, LineDirection.HORIZONTAL) || hasLine(playerSide, LineDirection.VERTICAL) || hasLine(playerSide, LineDirection.DIAGONAL);
    }

    public boolean hasEmptyCell() {
        for (int row = 0; row < DIMENSION; ++row) {
            for (int col = 0; col < DIMENSION; ++col) {
                if (cells[row][col].getContent() == CellContent.EMPTY) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    protected Board clone() {
        Board copyBoard = new Board();

        for (int row = 0; row < DIMENSION; row++) {
            for (int col = 0; col < DIMENSION; col++) {
                copyBoard.cells[row][col].setContent(this.cells[row][col].getContent());
            }
        }
        return copyBoard;
    }

    public void print() {
        for (int row = 0; row < DIMENSION; ++row) {
            for (int col = 0; col < DIMENSION; ++col) {
                cells[row][col].paint();
            }
            System.out.println();
        }
        System.out.println("--------------------");
    }
}
