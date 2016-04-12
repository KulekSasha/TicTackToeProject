package com.goit.gojavaonline.tictactoe;

/**
 * Created by User on 12.04.2016.
 */
public class TooFarFromRangeException extends Exception {

    private int index;

    public TooFarFromRangeException(int index){
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public String toString() {
        return "Input value " + index + " is above of board range";
    }
}
