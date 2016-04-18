package com.goit.gojavaonline.tictactoe.model;

/**
 * Created by SashaKulek on 07/04/2016.
 */

public enum CellContent {
    EMPTY(" _ "),CROSS(" X "),ZERO(" O ");

    private final String cellContentDescription;

    private CellContent(String value) {
        cellContentDescription = value;
    }

    public String getCellContentDescription() {
        return cellContentDescription;
    }

}
