package com.goit.gojavaonline.tictactoe;

/**
 * Created by tamila on 4/13/16.
 */
public class PlayerMove {
    private int depth;
    private int row;
    private int column;

    public PlayerMove(){
        super();
    }

    public PlayerMove(int depth, int row, int column){
        super();
        this.depth = depth;
        this.row = row;
        this.column = column;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void setMove(int depth, int row, int column){
        this.depth = depth;
        this.row = row;
        this.column = column;
    }
}
