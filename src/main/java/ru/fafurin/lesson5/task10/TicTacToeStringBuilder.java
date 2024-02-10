package ru.fafurin.lesson5.task10;

import java.util.Scanner;

public class TicTacToeStringBuilder {
    private StringBuilder builder = new StringBuilder();
    private Scanner scanner = new Scanner(System.in);

    private int[] indexes = new int[]{
            2, 6, 10,
            30, 34, 38,
            58, 62, 66
    };

    private String emptyLine = "| E | E | E |";
    private String line = " --- --- --- ";

    private String move;

    private char player;

    boolean isGameOver = false;

    public TicTacToeStringBuilder() {
        this.initGameField();
        this.printGameField();
        this.startGame();
    }

    public void startGame() {
        System.out.println("X or 0");
        char first = this.scanner.nextLine().charAt(0);
        if (first == 'X' || first == '0') {
            this.player = first;
        } else {
            System.out.println("I recognizing only X or 0. So first will be X");
            this.player = 'X';
        }

        while (!isGameOver) {
            this.isGameOver = this.checkGameFiledForFreeCells();
            this.move();
            this.isGameOver = this.checkEndGame(this.player);
            if (this.isGameOver) System.out.println(this.player + " win!");
            if (this.player == 'X') {
                this.player = '0';
            } else {
                this.player = 'X';
            }
            this.printGameField();
        }
        System.out.println("Game is over!");
    }

    public void printGameField() {
        System.out.println(this.builder);
        System.out.println();
    }

    public void move() {
        System.out.println(this.player + ", enter number of horizontal cell and number of vertical cell through whitespace...");
        this.move = this.scanner.nextLine();
        switchResult(this.move, this.player);
    }

    public void switchResult(String str, char player) {
        switch (str) {
            case "1 1" -> this.placeLetter(String.valueOf(player), 2);
            case "1 2" -> this.placeLetter(String.valueOf(player), 6);
            case "1 3" -> this.placeLetter(String.valueOf(player), 10);
            case "2 1" -> this.placeLetter(String.valueOf(player), 30);
            case "2 2" -> this.placeLetter(String.valueOf(player), 34);
            case "2 3" -> this.placeLetter(String.valueOf(player), 38);
            case "3 1" -> this.placeLetter(String.valueOf(player), 58);
            case "3 2" -> this.placeLetter(String.valueOf(player), 62);
            case "3 3" -> this.placeLetter(String.valueOf(player), 66);
            default -> System.out.println("Wrong numbers!");
        }
    }

    public void placeLetter(String letter, int index) {
        if (this.builder.charAt(index) == 'E') {
            this.builder.replace(index, index + 1, letter);
        }
    }

    public void initGameField() {
        this.builder.append(this.emptyLine);
        this.builder.append("\n");
        this.builder.append(this.line);
        this.builder.append("\n");
        this.builder.append(this.emptyLine);
        this.builder.append("\n");
        this.builder.append(this.line);
        this.builder.append("\n");
        this.builder.append(this.emptyLine);
    }

    public boolean checkEndGame(char letter) {
        if (checkIndex(2, 6, 10, letter)) return true;
        else if (checkIndex(30, 34, 38, letter)) return true;
        else if (checkIndex(58, 62, 66, letter)) return true;
        else if (checkIndex(2, 30, 58, letter)) return true;
        else if (checkIndex(6, 34, 62, letter)) return true;
        else if (checkIndex(10, 38, 66, letter)) return true;
        else if (checkIndex(2, 34, 66, letter)) return true;
        else if (checkIndex(10, 34, 58, letter)) return true;
        else return false;
    }

    public boolean checkIndex(int index1, int index2, int index3, char letter) {
        return this.builder.charAt(index1) == letter &&
                this.builder.charAt(index2) == letter &&
                this.builder.charAt(index3) == letter;
    }

    public boolean checkGameFiledForFreeCells() {
        boolean result = false;
        for (int x = 0; x < this.builder.length(); x++) {
            if (this.builder.charAt(x) == 'E') {
                result = true;
            }
        }
        return result;
    }


}
