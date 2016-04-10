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

    public boolean isWin(CellContent playerSide) {
        if ((cells[0][0].getContent() == playerSide && cells[0][1].getContent() == playerSide && cells[0][2].getContent() == playerSide) ||
                (cells[1][0].getContent() == playerSide && cells[1][1].getContent() == playerSide && cells[1][2].getContent() == playerSide) ||
                (cells[2][0].getContent() == playerSide && cells[2][1].getContent() == playerSide && cells[2][2].getContent() == playerSide) ||

                (cells[0][0].getContent() == playerSide && cells[1][0].getContent() == playerSide && cells[2][0].getContent() == playerSide) ||
                (cells[0][1].getContent() == playerSide && cells[1][1].getContent() == playerSide && cells[2][1].getContent() == playerSide) ||
                (cells[0][2].getContent() == playerSide && cells[1][2].getContent() == playerSide && cells[2][2].getContent() == playerSide) ||

                (cells[0][0].getContent() == playerSide && cells[1][1].getContent() == playerSide && cells[2][2].getContent() == playerSide) ||
                (cells[2][0].getContent() == playerSide && cells[1][1].getContent() == playerSide && cells[0][2].getContent() == playerSide)
                ) {
            return true;
        } else {
            return false;
        }
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
