package ru.fafurin.lesson10.task1;

public class TicTacToeGameField {
    private final int size;

    private final int cellsCountToWin;

    public char[][] field;

    public TicTacToeGameField(int size, int cellsCountToWin) {
        this.size = size;
        this.cellsCountToWin = cellsCountToWin;
        this.setField();
    }

    private void setField() {
        this.field = new char[this.size][this.size];
        for (int row = 0; row < this.size; row++) {
            for (int col = 0; col < this.size; col++) {
                this.field[row][col] = ' ';
            }
        }
    }

    public void setCellValue(int row, int col, char value) {
        this.field[row][col] = value;
    }

    public boolean isCellFree(int row, int col) {
        return this.field[row][col] == ' ';
    }

    public void printField() {
        System.out.print("   ");
        for (int x = 0; x < this.size; x++) {
            System.out.print(x + 1);
            String str = String.valueOf(x + 1);
            for (int i = 0; i < 3 - str.length(); i++) {
                System.out.print(" ");
            }
        }
        System.out.println();
        for (int row = 0; row < this.size; row++) {
            System.out.print(row + 1 + " ");
            for (int col = 0; col < this.size; col++) {
                System.out.print("[" + this.field[row][col] + "]");
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean isGameOver(char player) {
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                if (checkLine(i, j, 1, 0, this.cellsCountToWin, player)) return true;
                if (checkLine(i, j, 1, 1, this.cellsCountToWin, player)) return true;
                if (checkLine(i, j, 0, 1, this.cellsCountToWin, player)) return true;
                if (checkLine(i, j, 1, -1, this.cellsCountToWin, player)) return true;
            }
        }
        return false;
    }

    private boolean checkLine(int x, int y, int vx, int vy, int len, char player) {
        int farX = x + (len - 1) * vx;
        int farY = y + (len - 1) * vy;
        if (!isValidCell(farX, farY)) {
            return false;
        }
        for (int i = 0; i < len; i++) {
            if (field[y + i * vy][x + i * vx] != player) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidCell(int x, int y) {
        return x >= 0 && x < this.size && y >= 0 && y < this.size;
    }

}
