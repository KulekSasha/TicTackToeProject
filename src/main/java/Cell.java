/**
 * Created by SashaKulek on 07/04/2016.
 */

public class Cell {
        // package access
        private CellContent content; // content of this cell of type Seed.
        // take a value of Seed.EMPTY, Seed.CROSS, or Seed.NOUGHT

        private int row, col; // row and column of this cell, not used in this program

        /** Constructor to initialize this cell */
        public Cell(int row, int col) {
            this.row = row;
            this.col = col;
            clear();  // clear content
        }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public CellContent getContent() {
        return content;
    }

    public void setContent(CellContent content) {
        this.content = content;
    }

    /** Clear the cell content to EMPTY */
        public void clear() {
            content = CellContent.EMPTY;
        }

        /** Paint itself */
        public void paint() {
            switch (content) {
                case CROSS:  System.out.print(" X "); break;
                case ZERO: System.out.print(" O "); break;
                case EMPTY:  System.out.print("   "); break;
            }
        }
    }

