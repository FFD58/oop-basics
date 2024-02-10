package ru.fafurin.lesson10.task2;

public class SnakeGameField {

    private int size = 20;

    private char[][] field;

    public SnakeGameField() {
        this.setField();
    }

    public int getSize() {
        return size;
    }

    public void setValue(int row, int col, char value) {
        this.field[row][col] = value;
    }

    public void setField() {
        this.field = new char[this.size][this.size];
        for (int row = 0; row < this.size; row++) {
            for (int col = 0; col < this.size; col++) {
                this.field[row][col] = ' ';
            }
        }
    }

    public void printField() {
        System.out.print("     ");
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
            String str = String.valueOf(row + 1);
            for (int i = 0; i < 3 - str.length(); i++) {
                System.out.print(" ");
            }
            for (int col = 0; col < this.size; col++) {
                System.out.print("[" + this.field[row][col] + "]");
            }
            System.out.println();
        }
        System.out.println();
    }

}
