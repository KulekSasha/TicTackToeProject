package com.goit.gojavaonline.tictactoe;

import java.util.Scanner;

/**
 * Created by tamila on 4/18/16.
 */
public class ConsoleUserInteraction implements UserInteraction {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    private Scanner scanner = new Scanner(System.in);

    @Override
    public void say(String message) {
        System.out.println(message);
    }

    @Override
    public void drawBoard(Board board) {
        System.out.println(board.toString());
    }

    @Override
    public void sayError(String message) {
        System.out.println(ANSI_RED + message + ANSI_RESET);
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
