import java.util.ArrayList;
import java.util.List;

/**
 * Created by SashaKulek on 07/04/2016.
 */

public class Board {
    public static final int ROWS = 3;
    public static final int COLS = 3;

    Cell[][] cells;  // a board composes of ROWS-by-COLS Cell instances
    int currentRow, currentCol;  // the current seed's row and column

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

    public boolean isWin(CellContent playerSide){


        return true;
    }
}
