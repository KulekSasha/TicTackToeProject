package com.goit.gojavaonline.tictactoe.exceptions;

/**
 * Created by User on 12.04.2016.
 */
public class TooFarFromRangeException extends Exception {

    private int index;

    public TooFarFromRangeException(int index, String message){
        super(message);
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

}
