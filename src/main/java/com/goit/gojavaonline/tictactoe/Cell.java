package com.goit.gojavaonline.tictactoe;

/**
 * Created by SashaKulek on 07/04/2016.
 */

public class Cell {
    private CellContent content;
    private int row, col;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        clear();
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public CellContent getContent() {
        return content;
    }

    public void setContent(CellContent content) {
        this.content = content;
    }

    public void clear() {
        content = CellContent.EMPTY;
    }

    public String getCellContentDescription(){
        return content.getCellContentDescription();
    }
}

