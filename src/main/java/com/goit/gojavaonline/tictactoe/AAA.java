package com.goit.gojavaonline.tictactoe;

/**
 * Created by SashaKulek on 08/04/2016.
 */

public class AAA {
    public static void main(String[] args) {
       Board b = new Board();
//        b.cells[0][0].setContent(com.goit.gojavaonline.tictactoe.CellContent.CROSS);
//        b.cells[1][1].setContent(com.goit.gojavaonline.tictactoe.CellContent.CROSS);
//        b.cells[2][2].setContent(com.goit.gojavaonline.tictactoe.CellContent.ZERO);


        Game g = new Game(b);

        g.startGame();
    }
}
