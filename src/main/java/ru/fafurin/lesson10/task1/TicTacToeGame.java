package ru.fafurin.lesson10.task1;

import java.util.Scanner;

public class TicTacToeGame {

    private TicTacToeGameField gameFild;
    private Scanner scanner = new Scanner(System.in);
    private char currentPlayer;

    private boolean isOverGame = false;

    public TicTacToeGame(int fieldSize, int countToWin) {
        this.gameFild = new TicTacToeGameField(fieldSize, countToWin);
        System.out.println("Welcome to closed beta testing of Tic-tac-toe game v. 0.1");
        gameFild.printField();
    }

    private void makeMove() {
        System.out.println(this.currentPlayer + ", make a move!");
        System.out.print("Enter row number: ");
        int row = scanner.nextInt() - 1;
        System.out.print("Enter col number: ");
        int col = scanner.nextInt() - 1;
        if (this.gameFild.isCellFree(row, col)) {
            this.gameFild.setCellValue(row, col, this.currentPlayer);
            this.gameFild.printField();
        } else {
            System.out.println("This cell is not empty!");
            this.makeMove();
        }
    }

    public void startGame() {
        System.out.println("Chose: X or 0...");
        this.currentPlayer = scanner.nextLine().charAt(0);
        if (this.currentPlayer != 'X' && this.currentPlayer != '0') {
            System.out.println("Do you want to play to Tic-tac-toe game, or not?");
            this.currentPlayer = 'X';
        }

        while (!this.isOverGame) {
            this.makeMove();
            this.isOverGame = this.gameFild.isGameOver(this.currentPlayer);
            if (this.isOverGame) System.out.println(this.currentPlayer + " win!");
            if (this.currentPlayer == 'X') this.currentPlayer = '0';
            else this.currentPlayer = 'X';
        }
        System.out.println("Game is over");
    }

}
