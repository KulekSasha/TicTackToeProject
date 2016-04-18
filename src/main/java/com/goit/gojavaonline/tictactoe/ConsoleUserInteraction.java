package com.goit.gojavaonline.tictactoe;

import java.util.Scanner;

/**
 * Created by tamila on 4/18/16.
 */
public class ConsoleUserInteraction implements UserInteraction {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public void say(String message) {
        System.out.println(message);
    }

    @Override
    public void say(Board board) {
        System.out.println(board.toString());
    }

    @Override
    public void sayError(String message) {
        System.err.println(message);
    }

    @Override
    public String ask(String message) {
        System.out.println(message);
        return scanner.nextLine().toUpperCase();
    }

    @Override
    public void endGame() {
        System.exit(0);
    }
}
